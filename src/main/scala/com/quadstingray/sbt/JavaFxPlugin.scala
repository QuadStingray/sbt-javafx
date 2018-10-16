package com.quadstingray.sbt

import com.quadstingray.sbt.javafx.model._
import com.quadstingray.sbt.javafx.{model, _}
import sbt.Keys.{crossTarget, _}
import sbt.{AutoPlugin, Def, _}

import scala.reflect.io.File

object JavaFxPlugin extends AutoPlugin {

  object autoImport extends SbtSettingsTrait {

    lazy val javaFxPluginTasks: Seq[Def.Setting[_]] = Seq(
      javaFxPrepareBuild := {
        packageBin.value
        val sbtTaskManager = new SbtTaskManager(streams.value.log, javaFxVerbose.value)
        sbtTaskManager.prepareBuild(javaFxGetAppSettings.value)
      },
      javaFxRunBuild := {
        val buildFile = File(javaFxGetAppSettings.value.javaFxBuildSettings.jarDir + "/build.xml")
        val sbtTaskManager = new SbtTaskManager(streams.value.log, javaFxVerbose.value)
        sbtTaskManager.runBuild(javaFxGetAppSettings.value, buildFile)
      },
      javaFxPackage := {
        val buildFile = javaFxPrepareBuild.value
        val sbtTaskManager = new SbtTaskManager(streams.value.log, javaFxVerbose.value)
        sbtTaskManager.runBuild(javaFxGetAppSettings.value, buildFile)
      },
      javaFxGetAppSettings := {
        model.AppSettings(
          JavaFxBuildSettings(
            javaFxNativeBundles.value,
            javaFxArtifactName.value,
            packageOptions.value,
            classDirectory.value,
            crossTarget.value,
            fullClasspath.value.map(_.data).filter(PluginCompat.ClasspathUtilities.isArchive).filterNot(_.getName.endsWith("jfxrt.jar")),
            javaFxCssToBin.value,
            javaFxVerbose.value,
            javaFxPostProcess.value
          ),
          JavaFxBuildPaths(javaFxAntPath.value, javaFxPkgResourcesPath.value),
          javaFxTemplate.value,
          AppDimensions(javaFxWidth.value, javaFxHeight.value, javaFxEmbeddedWidth.value, javaFxEmbeddedHeight.value),
          javaFxPermissions.value,
          AppInfo(javaFxMainClass.value, javaFxVendor.value, javaFxTitle.value, javaFxAppVersion.value, javaFxCategory.value, javaFxCopyright.value, javaFxDescription.value, javaFxLicense.value),
          SigningSettings(javaFxKeyStore.value, javaFxStorePass.value, javaFxSigningAlias.value, javaFxSigningKeyPass.value, javaFxSigningKeyStoreType.value),
          JavaPlatformSettings(javaFxJavafx.value, javaFxJ2se.value, javaFxJvmargs.value, javaFxJvmuserargs.value, javaFxProperties.value),
          javaFxFileAssociations.value
        )
      }
    )
  }

  import autoImport._

  override def requires = sbt.plugins.JvmPlugin

  override def trigger = allRequirements

  override val projectSettings: Seq[Def.Setting[_]] = inConfig(Compile)(javaFxPluginTasks) ++ javaFxPluginSettings

}
