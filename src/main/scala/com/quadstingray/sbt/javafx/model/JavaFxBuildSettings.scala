package com.quadstingray.sbt.javafx.model

import sbt.Package.{JarManifest, ManifestAttributes}
import sbt.{File, PackageOption, _}

import scala.collection.JavaConverters._
import scala.xml.{Elem, NodeBuffer}

case class JavaFxBuildSettings(nativeBundles: String, artifactName: String, packOptions: Seq[PackageOption], classDir: sbt.File, jarDir: sbt.File, libJars: Seq[sbt.File], cssToBin: Boolean, verbose: Boolean, postProcess: () => Unit) {

  def libDir: File = jarDir / "lib"

  def distDir: File = jarDir / artifactName

  def jarFile: File = jarDir / (artifactName + ".jar")

  def getCssToBinXML: Option[NodeBuffer] = {
    if (cssToBin) {
      Some(
        <delete>
          <fileset dir={classDir.getAbsolutePath} includes="**/*.bss"/>
        </delete>
          <fx:csstobin outdir={classDir.getAbsolutePath}>
            <fileset dir={classDir.getAbsolutePath} includes="**/*.css"/>
          </fx:csstobin>
      )
    } else {
      None
    }
  }

  def getJarXML(appRefId: String, jarFile: File): Elem = {
    val manifestAttributes = packOptions.collect {
      case attributes: ManifestAttributes => attributes.attributes.map { case (key, value) => (key.toString, value) }
      case JarManifest(manifest) => manifest.getMainAttributes.entrySet.asScala.map(entry => (entry.getKey.toString, entry.getValue.toString)).toList
    }.flatten

    val manifestXMLAttributes = manifestAttributes map { case (key, value) => <attribute name={key} value={value}/> }

    <fx:jar destfile={jarFile.getAbsolutePath}>
      <fx:application refid={appRefId}/>
      <fx:platform refid="platform"/>
      <fx:fileset dir={classDir.getAbsolutePath}/>
      <fx:resources>
        {if (libJars.nonEmpty)
          <fx:fileset dir={jarDir.getAbsolutePath} includes="lib/*.jar"/>}
      </fx:resources>{if (manifestXMLAttributes.nonEmpty)
      <manifest>
        {manifestXMLAttributes}
      </manifest>}
    </fx:jar>
  }

}
