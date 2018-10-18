package com.quadstingray.sbt.javafx.utils

object SystemTools {
  def getJavaVersion: String = System.getProperty("java.version")

  def getJavaVendor: String = System.getProperty("java.vendor")

  def getJavaVendorUrl: String = System.getProperty("java.vendor.url")

  def getJavaHome: String = System.getProperty("java.home")

  def getOSName: String = System.getProperty("os.name")

  def getOSArchitecture: String = System.getProperty("os.arch")

  def getOSVersion: String = System.getProperty("os.version")

  def isMacOS: Boolean = getOSName.toLowerCase().contains("mac")

  def isWindowsOS: Boolean = getOSName.toLowerCase().contains("windows")

  def getFileSeparator: String = System.getProperty("file.separator")

  def getPathSeparator: String = System.getProperty("path.separator")

  def getLineSeparator: String = System.getProperty("line.separator")

  def getUserName: String = System.getProperty("user.name")

  def getUserHomeDirectory: String = System.getProperty("user.home")

  def getCurrentUserDirectory: String = System.getProperty("user.dir")

  def getTempPath: String = System.getProperty("java.io.tmpdir")
}
