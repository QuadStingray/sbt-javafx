import scala.reflect.io.File

name := "sbt-antjar-change"

organization := "com.quadstingray"

version := "0.1"

scalaVersion := "2.12.8"

enablePlugins(JavaFxPlugin)

mainClass := Option("com.quadstingray.javafx.sample.HelloApp")

javaFxNativeBundles := "deb"

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

TaskKey[Unit]("checkFilePackaged") := {
  val bundledFile1 = File((crossTarget.value / "%s_%s-%s".format(name.value, scalaVersion.value, version.value) / "%s-%s.deb".format(name.value, version.value)).toString)
  val bundledFile2 = File((crossTarget.value / "%s_%s-%s".format(name.value, scalaVersion.value, version.value) / "bundles" / "%s-%s.deb".format(name.value, version.value)).toString)

  if (!(bundledFile1.exists || bundledFile2.exists))
    throw new Exception("Bundled File " + bundledFile1.toString + "or Bundle File" + bundledFile2.toString + " not found!")

  ()
}

val osName: SettingKey[String] = SettingKey[String]("osName")

osName := (System.getProperty("os.name") match {
  case name if name.startsWith("Linux") => "linux"
  case name if name.startsWith("Mac") => "mac"
  case name if name.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
})

libraryDependencies += "org.openjfx" % "javafx-base" % "11" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-controls" % "11" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-fxml" % "11" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-graphics" % "11" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-media" % "11" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-web" % "11" classifier osName.value