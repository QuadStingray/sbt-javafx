import scala.reflect.io.File

name := "sbt-antjar-change"

organization := "com.quadstingray"

version := "0.1"

scalaVersion := "2.12.7"

enablePlugins(JavaFxPlugin)

mainClass := Option("com.quadstingray.javafx.sample.HelloApp")

javaFxNativeBundles := "image"

//#alternativ-ant-path
javaFxAntPath := "alternativ/path/ant-javafx.jar"
//#alternativ-ant-path

TaskKey[Unit]("check") := {
  val outputFile = File((crossTarget.value / "build.xml").toString)
  val content = scala.io.Source.fromFile(outputFile.toAbsolute.toString()).mkString
  if (!content.contains("alternativ/path/ant-javafx.jar"))
    throw new Exception("alternativ ant path not in " + outputFile.toString)
  ()
}