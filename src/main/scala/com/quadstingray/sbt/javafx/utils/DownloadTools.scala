package com.quadstingray.sbt.javafx.utils

import java.net.HttpURLConnection

import sbt.Logger

import scala.reflect.io.File
import sys.process._
import java.net.URL

object DownloadTools {
  def downloadToTempFile(urlString: String, logger: Logger): File = {
    logger.info("Started Download javafx-ant.jar")

    val tempFile = java.io.File.createTempFile("downloaded-javafx-ant-", ".jar")
    tempFile.deleteOnExit()
    val downloadFile = File(tempFile.toString)

    val url = new URL(urlString)

    val connection = url.openConnection().asInstanceOf[HttpURLConnection]

    val timeout: Int = 5000
    connection.setConnectTimeout(timeout)
    connection.setReadTimeout(timeout)
    connection.connect()

    if (connection.getResponseCode >= 400) {
      logger.error("downloading error status code == " + connection.getResponseCode)
    }
    else {
      (url #> downloadFile.outputStream()).!!
    }

    logger.info("Started Download javafx-ant.jar")

    downloadFile
  }

  val DownloadUrlAntJavaFxJarMac = "https://github.com/QuadStingray/sbt-javafx/raw/master/src/sbt-test/mac/antjar-change/alternativ/path/ant-javafx.jar"
  val DownloadUrlAntJavaFxJarWindows = "https://github.com/QuadStingray/sbt-javafx/raw/master/src/sbt-test/windows/antjar-change/alternativ/path/ant-javafx.jar"
  val DownloadUrlAntJavaFxJarLinux = "https://github.com/QuadStingray/sbt-javafx/raw/master/src/sbt-test/linux/antjar-change/alternativ/path/ant-javafx.jar"
}
