package com.quadstingray.sbt.javafx.model

//	Types and utils used for jdk/sdk configuration

trait JavaDevKit

case class JDK(path: String) extends JavaDevKit

case class SDK(path: String) extends JavaDevKit

object JavaDevKit {

  def jfxrt(devKit: JavaDevKit): String = devKit match {
    case JDK(path) => path + "/jre/lib/jfxrt.jar"
    case SDK(path) => path + "/rt/lib/jfxrt.jar"
  }

  def antLib(devKit: JavaDevKit): String = devKit match {
    case JDK(path) => path + "/lib/ant-javafx.jar"
    case SDK(path) => path + "/lib/ant-javafx.jar"
  }

  def isJdk(devKit: JavaDevKit): Boolean = devKit.isInstanceOf[JDK]

}
