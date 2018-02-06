package com.quadstingray.sbt.javafx.model

import scala.reflect.io.File

trait JavaDevKit {
  def path: String

  def jfxrt: String

  def antLib: String = path + "/lib/ant-javafx.jar"

  def isJdk: Boolean = this.isInstanceOf[JDK]
}

case class JDK(path: String) extends JavaDevKit {
  override def jfxrt: String = path + "/jre/lib/jfxrt.jar"
}

case class SDK(path: String) extends JavaDevKit {
  override def jfxrt: String = path + "/rt/lib/jfxrt.jar"
}