package com.quadstingray.sbt.javafx.model

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
