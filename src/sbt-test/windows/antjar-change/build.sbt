import scala.reflect.io.File

name := "sbt-antjar-change"

organization := "com.quadstingray"

version := "0.1"

scalaVersion := "2.12.8"

enablePlugins(JavaFxPlugin)

mainClass := Option("com.quadstingray.javafx.sample.HelloApp")

javaFxNativeBundles := "all"

//#alternativ-ant-path
javaFxAntPath := "alternativ/path/ant-javafx.jar"
//#alternativ-ant-path

TaskKey[Unit]("check") := {
  val outputFile = File((crossTarget.value / "build.xml").toString)
  val content    = scala.io.Source.fromFile(outputFile.toAbsolute.toString()).mkString
  if (!content.contains("alternativ/path/ant-javafx.jar"))
    throw new Exception("alternativ ant path not in " + outputFile.toString)
  ()
}

val osName: SettingKey[String] = SettingKey[String]("osName")

osName := (System.getProperty("os.name") match {
  case name if name.startsWith("Linux")   => "linux"
  case name if name.startsWith("Mac")     => "mac"
  case name if name.startsWith("Windows") => "win"
  case _                                  => throw new Exception("Unknown platform!")
})

libraryDependencies += "org.openjfx" % "javafx-base" % "11" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-controls" % "11" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-fxml" % "11" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-graphics" % "11" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-media" % "11" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-web" % "11" classifier osName.value
