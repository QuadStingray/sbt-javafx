package com.quadstingray.sbt.javafx

import com.quadstingray.sbt.javafx.model.AppSettings
import com.quadstingray.sbt.javafx.utils.SystemTools
import org.apache.tools.ant
import org.apache.tools.ant.{BuildEvent, BuildListener}
import sbt._

import scala.collection.mutable.ArrayBuffer
import scala.reflect.io.File


class SbtTaskManager(logger: Logger, logAntInformations: Boolean) {

  def prepareBuild(settings: AppSettings): File = {

    logger.info("started prepare build")

    val buildFile = File(settings.javaFxBuildSettings.jarDir.getAbsolutePath + SystemTools.getFileSeparator + "build.xml")

    settings.prepare(logger)

    if (buildFile.exists) {
      buildFile.delete()
    }

    buildFile.writeAll(settings.toXMLString)

    logger.info("prepare build finished")
    buildFile
  }

  private val buildListener = new BuildListener {

    override def taskStarted(buildEvent: BuildEvent): Unit = {
      if (logAntInformations) {
        logger.info("antProject.taskStarted: " + buildEvent.getProject.getName + " - " + buildEvent.getTask.getTaskName)
      }
    }

    override def taskFinished(buildEvent: BuildEvent): Unit = {
      if (logAntInformations) {
        logger.info("antProject.taskStarted: " + buildEvent.getProject.getName + " - " + buildEvent.getTask.getTaskName)
      }
    }

    override def buildStarted(buildEvent: BuildEvent): Unit = {
      if (logAntInformations) {
        logger.info("antProject.buildStarted: " + buildEvent.getProject.getName)
      }
    }

    override def buildFinished(buildEvent: BuildEvent): Unit = {
      if (logAntInformations) {
        logger.info("antProject.buildFinished: " + buildEvent.getProject.getName)
      }
    }


    override def targetStarted(buildEvent: BuildEvent): Unit = {
      if (logAntInformations) {
        logger.info("antProject.targetStarted: " + buildEvent.getProject.getName + " - " + buildEvent.getTarget.getName)
      }
    }

    override def targetFinished(buildEvent: BuildEvent): Unit = {
      if (logAntInformations) {
        logger.info("antProject.targetFinished: " + buildEvent.getProject.getName + " - " + buildEvent.getTarget.getName)
      }
    }

    override def messageLogged(buildEvent: BuildEvent): Unit = {
      if (logAntInformations) {
        logger.info("antProject.message: " + buildEvent.getMessage)
      }
    }
  }

  def runBuild(settings: AppSettings, buildFile: File): Unit = {
    logger.info("build started")

    val javaHome = File(settings.buildPaths.javaHome)
    val files: ArrayBuffer[File] = workaroundForJavaWithMovedJli(javaHome)

    val antProject = new ant.Project

    antProject.addBuildListener(buildListener)

    antProject.setUserProperty("ant.file", buildFile.path.toString)

    antProject.init()

    ant.ProjectHelper.getProjectHelper.parse(antProject, buildFile.jfile)

    antProject.executeTarget("default")

    logger.info("build finished")
    logger.info("Post Process started")
    settings.javaFxBuildSettings.postProcess()
    logger.info("Post Process finished")

    files.foreach(_.delete())
  }

  private def workaroundForJavaWithMovedJli(javaHome: File): ArrayBuffer[File] = {
    val files: ArrayBuffer[File] = ArrayBuffer()

    val version = getJavaHomeVersion(javaHome)
    if (version.startsWith("12.") || version.startsWith("13.")) {
      val targetFile = javaHome / "lib" / "jli" / "libjli.dylib"

      if (!(javaHome / "lib").exists) {
        files += File(javaHome / "lib")
      }

      if (!targetFile.exists) {
        val sourceFile = javaHome / "lib" / "libjli.dylib"
        if (sourceFile.exists) {
          sbt.IO.copyFile(sourceFile.jfile, targetFile.jfile)
          files += File(targetFile)
        } else {
          throw new Exception("libjli.dylib not found on expected location for Java 12 or 13 <%s>".format(sourceFile))
        }
      }
    }

    files
  }

  def getJavaHomeVersion(javaHome: File): String = {
    val releaseFile = javaHome / "release"
    if (releaseFile.exists) {
      val content = sbt.IO.read(releaseFile.jfile)
      val version = "JAVA_VERSION=\"(.*?)\"".r.findFirstIn(content).getOrElse("").replace("JAVA_VERSION=\"", "").replace("\"", "")
      version
    } else {
      ""
    }
  }

}
