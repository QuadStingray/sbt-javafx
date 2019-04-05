package com.quadstingray.sbt.javafx

import com.quadstingray.sbt.javafx.model._
import com.quadstingray.sbt.javafx.utils.SystemTools
import sbt.Keys._
import sbt.{Def, _}

import scala.reflect.io.File

trait SbtSettingsTrait {

  // Tasks
  val javaFxPackage = taskKey[Unit]("Packages a JavaFX application.")

  val javaFxPrepareBuild = taskKey[scala.reflect.io.File]("Prepare Build of JavaFX application.")

  val javaFxRunBuild = taskKey[Unit]("Run Build of prepared JavaFX application.")

  val javaFxGetAppSettings = taskKey[AppSettings]("Get AppSettings from SBT keys.")

  val javaFxMainClass = taskKey[String]("Main Class for JavaFX application, must extend javafx.application.Application and implement the start() method.")

  // Settings
  val javaFxJavaHome = settingKey[String]("Path to java home for self-contained applications")

  val javaFxAntPath = settingKey[String]("Path to JavaFx Ant jar ")

  val javaFxPkgResourcesPath = settingKey[String]("Path containing the `package/{windows,macosx,linux}` directory for drop-in resources. See https://blogs.oracle.com/talkingjavadeployment/entry/native_packaging_cookbook_using_drop for details.")

  val javaFxJavaOnly = settingKey[Boolean]("Setting for JavaFX applications in pure Java, sets some other settings to usable defaults for this scenario.")

  val javaFxNativeBundles = settingKey[String]("Which native bundles to create, if default `all`.")

  val javaFxArtifactName = settingKey[String]("the actual name of the JavaFX artifact without file extension.")

  val javaFxTemplate = settingKey[TemplateSettings]("JavaFX HTML template settings.")

  val javaFxVendor = settingKey[String]("the vendor for the JavaFx Application.")

  val javaFxTitle = settingKey[String]("the title for the JavaFx Application.")

  val javaFxAppVersion = settingKey[String]("the version  for the JavaFx Application, used in launcher and installer")

  val javaFxCategory = settingKey[String]("the category for the JavaFx Application.")

  val javaFxDescription = settingKey[String]("the description for the JavaFx Application.")

  val javaFxCopyright = settingKey[String]("the copyright for the JavaFx Application.")

  val javaFxLicense = settingKey[String]("the license for the JavaFx Application.")

  val javaFxWidth = settingKey[Int]("the width for the JavaFx Application.")

  val javaFxHeight = settingKey[Int]("the height for the JavaFx Application.")

  val javaFxEmbeddedWidth = settingKey[String]("the width for JavaFX applet.")

  val javaFxEmbeddedHeight = settingKey[String]("the height for JavaFX applet.")

  val javaFxPermissions = settingKey[Permissions]("the permission settings for the JavaFx Application.")

  val javaFxKeyStore = settingKey[Option[sbt.File]]("filename for keystore for jar signing.")

  val javaFxStorePass = settingKey[Option[String]]("password for keystore for jar signing.")

  val javaFxSigningAlias = settingKey[Option[String]]("key name for jar signing.")

  val javaFxSigningKeyPass = settingKey[Option[String]]("key password for jar signing.")

  val javaFxSigningKeyStoreType = settingKey[Option[String]]("keystore type for signing.")

  val javaFxPostProcess = settingKey[() => Unit]("post-processing of the packaged artifact. (Optionally)")

  val javaFxCssToBin = settingKey[Boolean]("convert CSS files to binary.")

  val javaFxVerbose = settingKey[Boolean]("sets verbose flag in fx:deploy task and log the output of ant task to sbt console")

  val javaFxJavafx = settingKey[Option[String]]("required JavaFX version.")

  val javaFxJ2se = settingKey[Option[String]]("required JRE version.")

  val javaFxJvmargs = settingKey[Seq[String]]("JVM options.")

  val javaFxJvmuserargs = settingKey[Seq[(String, String)]]("user overridable JVM options.")

  val javaFxProperties = settingKey[Seq[(String, String)]]("JVM properties.")

  val javaFxFileAssociations = settingKey[Seq[FileAssociation]]("seq of file associations")

  lazy val javaFxPluginSettings: Seq[Def.Setting[_]] = {

    val javaHome = if (SystemTools.getJavaHome.endsWith(SystemTools.getFileSeparator)) {
      SystemTools.getJavaHome.split(SystemTools.getFileSeparator).mkString(SystemTools.getFileSeparator)
    }
    else {
      SystemTools.getJavaHome
    }

    val baseAntPath = javaHome + SystemTools.getFileSeparator + ".." + SystemTools.getFileSeparator + "lib" + SystemTools.getFileSeparator + "ant-javafx.jar"


    val defaultAntPath =
      if (File(baseAntPath).exists) {
        baseAntPath
      } else {
        javaHome + SystemTools.getFileSeparator + "lib" + SystemTools.getFileSeparator + "ant-javafx.jar"
      }

    Seq(
      javaFxJavaHome := javaHome,
      javaFxAntPath := defaultAntPath,
      javaFxPkgResourcesPath := (baseDirectory.value / ("src" + SystemTools.getFileSeparator + "deploy")).getAbsolutePath,
      javaFxJavaOnly := false,
      javaFxNativeBundles := "all",
      javaFxArtifactName := List(Some(artifact.value.name), Some("_" + scalaVersion.value), Some("-" + projectID.value.revision)).flatten.mkString,
      javaFxTemplate := TemplateSettings(None, None),
      javaFxVendor := "Unknown",
      javaFxTitle := name.value,
      javaFxAppVersion := version.value,
      javaFxCategory := "",
      javaFxDescription := description.value,
      javaFxCopyright := "",
      javaFxLicense := licenses.value.headOption.getOrElse(("", ""))._1,
      javaFxWidth := 800,
      javaFxHeight := 800,
      javaFxEmbeddedWidth := "100%",
      javaFxEmbeddedHeight := "100%",
      javaFxPermissions := Permissions(elevated = false, cacheCertificates = false),
      javaFxKeyStore := None,
      javaFxStorePass := None,
      javaFxSigningAlias := None,
      javaFxSigningKeyPass := None,
      javaFxSigningKeyStoreType := None,
      javaFxJavafx := None,
      javaFxJ2se := None,
      javaFxJvmargs := Seq(),
      javaFxJvmuserargs := Seq(),
      javaFxProperties := Seq(),
      javaFxCssToBin := false,
      javaFxVerbose := false,
      javaFxPostProcess := { () => },
      javaFxFileAssociations := Seq(),
      javaFxMainClass := (mainClass in Compile).value.getOrElse("")
    )
  }

}
