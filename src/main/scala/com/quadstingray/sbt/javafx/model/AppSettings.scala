package com.quadstingray.sbt.javafx.model

import java.net.HttpURLConnection

import sbt.{IO, _}

import scala.reflect.io.File
import scala.xml.Elem

case class AppSettings(javaFxBuildSettings: JavaFxBuildSettings, buildPaths: JavaFxBuildPaths, template: TemplateSettings, dimensions: AppDimensions, permissions: Permissions, appInfo: AppInfo, signing: SigningSettings, platformSettings: JavaPlatformSettings, fileAssociations: Seq[FileAssociation]) {

  def prepare(logger: Logger): Unit = {

    var antJarFile = File(buildPaths.javafxAntPath)
    if (buildPaths.javafxAntPath.equalsIgnoreCase("") && !antJarFile.exists) {
      logger.info("Started Download javafx-ant.jar")
      import sys.process._
      import java.net.URL

      antJarFile = scala.reflect.io.File.makeTemp("downloaded-javafx-ant-", ".jar")
      buildPaths.javafxAntPath = antJarFile.toAbsolute.toString()

      val url = new URL("https://github.com/QuadStingray/sbt-javafx/raw/master/src/sbt-test/sbt-javafx/antjar-change/alternativ/path/ant-javafx.jar")

      val connection = url.openConnection().asInstanceOf[HttpURLConnection]
      connection.setConnectTimeout(5000)
      connection.setReadTimeout(5000)
      connection.connect()

      if (connection.getResponseCode >= 400)
        println("error")
      else
        (url #> antJarFile.outputStream()).!!

      logger.info("Started Download javafx-ant.jar")
    }

    if (buildPaths.javafxAntPath != antJarFile.toAbsolute.toString())
      buildPaths.javafxAntPath = antJarFile.toAbsolute.toString()

    IO.delete(javaFxBuildSettings.libDir)
    IO.delete(javaFxBuildSettings.distDir)

    if (javaFxBuildSettings.distDir.exists && javaFxBuildSettings.distDir.list.nonEmpty)
      sys.error("Could not delete previous build. Make sure no files are open in " + javaFxBuildSettings.distDir)

    val srcToDest = javaFxBuildSettings.libJars.map(src => (src, javaFxBuildSettings.libDir / src.getName))

    IO.copy(srcToDest)
  }
  def toXMLString: String = {

    val antBuildXml: Elem =
      <project name={appInfo.title} default="default" basedir="." xmlns:fx="javafx:com.sun.javafx.tools.ant">

        <property name="JAVA_HOME" value={buildPaths.javaHome}/>

        <target name="default">
          <taskdef resource="com/sun/javafx/tools/ant/antlib.xml" uri="javafx:com.sun.javafx.tools.ant" classpath={buildPaths.pkgResourcesPath + ":" + buildPaths.javafxAntPath}/>{javaFxBuildSettings.getCssToBinXML.getOrElse("")}{appInfo.getApplicationXML}{platformSettings.getXML}{javaFxBuildSettings.getJarXML(appInfo.title, javaFxBuildSettings.jarFile)}{if (permissions.elevated) {
          signing.getSigningXml(javaFxBuildSettings.distDir)
          if (javaFxBuildSettings.libJars.nonEmpty) {
            signing.getSigningXml(javaFxBuildSettings.libDir)
          }
        }}<fx:deploy width={dimensions.width.toString} height={dimensions.height.toString} embeddedWidth={dimensions.embeddedWidth} embeddedHeight={dimensions.embeddedHeight} outdir={javaFxBuildSettings.distDir.getAbsolutePath} outfile={javaFxBuildSettings.artifactName}
                     placeholderId="javafx" nativeBundles={javaFxBuildSettings.nativeBundles} verbose={javaFxBuildSettings.verbose.toString}>
          <fx:platform refid="platform"/>
          <fx:application refid={appInfo.title}/>
          <fx:info vendor={appInfo.vendor} title={appInfo.title} category={appInfo.category} description={appInfo.description} copyright={appInfo.copyright} license={appInfo.license}>
            {fileAssociations.map(association =>
            association.getXml
          )}
          </fx:info>
          <fx:resources>
            <fx:fileset dir={javaFxBuildSettings.jarDir.getAbsolutePath} includes={javaFxBuildSettings.artifactName + ".jar"}/>{if (javaFxBuildSettings.libJars.nonEmpty)
              <fx:fileset dir={javaFxBuildSettings.jarDir.getAbsolutePath} includes="lib/*.jar"/>}
          </fx:resources>
          <fx:permissions elevated={permissions.elevated.toString} cacheCertificates={permissions.cacheCertificates.toString}/>{if (template.file.isDefined) {
            val tf = template.file.get
              <fx:template file={tf.getAbsolutePath} tofile={template.destFile.getOrElse(tf).getAbsolutePath}/>
          }}
        </fx:deploy>
        </target>
      </project>

    antBuildXml.toString()
  }
}

