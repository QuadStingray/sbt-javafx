import scala.reflect.io.File
//#sample-build-sbt
name := "sbt-licences-simple"

organization := "com.quadstingray"

version := "0.1"

scalaVersion := "2.12.8"

enablePlugins(JavaFxPlugin)

javaFxMainClass := "com.quadstingray.javafx.sample.HelloApp"

licenses += ("Apache-2.0", url("https://github.com/QuadStingray/sbt-javafx/blob/master/LICENSE"))

//#sample-build-sbt

//#for-debug-activate
javaFxVerbose := true
//#for-debug-activate

javaFxNativeBundles := "deb"

TaskKey[Unit]("checkFilePackaged") := {
  val bundledFile1 =
    File((crossTarget.value / "%s_%s-%s".format(name.value, scalaVersion.value, version.value) / "%s-%s.deb".format(name.value, version.value)).toString)
  val bundledFile2 = File(
    (crossTarget.value / "%s_%s-%s".format(name.value, scalaVersion.value, version.value) / "bundles" / "%s-%s.deb".format(name.value, version.value)).toString
  )

  if (!(bundledFile1.exists || bundledFile2.exists))
    throw new Exception("Bundled File " + bundledFile1.toString + "or Bundle File" + bundledFile2.toString + " not found!")

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
