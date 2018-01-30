package com.quadstingray.sbt.javafx

import better.files.File
import com.quadstingray.sbt.javafx.model.AppSettings
import org.apache.tools.ant
import org.apache.tools.ant.{BuildEvent, BuildListener}
import sbt.internal.util.ManagedLogger

class SbtTaskManager(logger: ManagedLogger, logAntInformations: Boolean) {

  def prepareBuild(settings: AppSettings): File = {

    logger.info("started prepare build")

    val buildFile = File(settings.javaFxBuildSettings.jarDir.getAbsolutePath + "/build.xml")

    settings.prepare()

    if (buildFile.exists)
      buildFile.delete()

    buildFile.append(settings.toXMLString)

    logger.info("prepare build finished")
    buildFile
  }

  def runBuild(settings: AppSettings, buildFile: File): Unit = {
    logger.info("build started")

    val antProject = new ant.Project

    antProject.addBuildListener(new BuildListener {

      override def taskStarted(buildEvent: BuildEvent): Unit = {
        if (logAntInformations)
          logger.info("antProject.taskStarted: " + buildEvent.getProject.getName + " - " + buildEvent.getTask.getTaskName)
      }

      override def taskFinished(buildEvent: BuildEvent): Unit = {
        if (logAntInformations)
          logger.info("antProject.taskStarted: " + buildEvent.getProject.getName + " - " + buildEvent.getTask.getTaskName)
      }

      override def buildStarted(buildEvent: BuildEvent): Unit = {
        if (logAntInformations)
          logger.info("antProject.buildStarted: " + buildEvent.getProject.getName)
      }

      override def buildFinished(buildEvent: BuildEvent): Unit = {
        if (logAntInformations)
          logger.info("antProject.buildFinished: " + buildEvent.getProject.getName)
      }


      override def targetStarted(buildEvent: BuildEvent): Unit = {
        if (logAntInformations)
          logger.info("antProject.targetStarted: " + buildEvent.getProject.getName + " - " + buildEvent.getTarget.getName)
      }

      override def targetFinished(buildEvent: BuildEvent): Unit = {
        if (logAntInformations)
          logger.info("antProject.targetFinished: " + buildEvent.getProject.getName + " - " + buildEvent.getTarget.getName)
      }

      override def messageLogged(buildEvent: BuildEvent): Unit = {
        if (logAntInformations)
          logger.info("antProject.message: " + buildEvent.getMessage)
      }
    })

    antProject.setUserProperty("ant.file", buildFile.path.toString)

    antProject.init()

    ant.ProjectHelper.getProjectHelper.parse(antProject, buildFile.toJava)

    antProject.executeTarget("default")

    logger.info("build finished")
    logger.info("Post Process started")
    settings.javaFxBuildSettings.postProcess()
    logger.info("Post Process finished")
  }

}
