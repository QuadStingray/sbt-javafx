package com.quadstingray.sbt.javafx.utils

import java.net.HttpURLConnection

import sbt.Logger

import scala.reflect.io.File

object DownloadTools {
  def downloadToTempFile(urlString: String, logger: Logger): File = {
    logger.info("Started Download javafx-ant.jar")
    import sys.process._
    import java.net.URL

    val tempFile = java.io.File.createTempFile("downloaded-javafx-ant-", ".jar")
    tempFile.deleteOnExit()
    val downloadFile = File(tempFile.toString)

    val url = new URL(urlString)

    val connection = url.openConnection().asInstanceOf[HttpURLConnection]
    connection.setConnectTimeout(5000)
    connection.setReadTimeout(5000)
    connection.connect()

    if (connection.getResponseCode >= 400)
      println("error")
    else
      (url #> downloadFile.outputStream()).!!

    logger.info("Started Download javafx-ant.jar")

    downloadFile
  }

  val DownloadUrlAntJavaFxJar = "https://github.com/QuadStingray/sbt-javafx/raw/master/src/sbt-test/sbt-javafx/antjar-change/alternativ/path/ant-javafx.jar"
}
