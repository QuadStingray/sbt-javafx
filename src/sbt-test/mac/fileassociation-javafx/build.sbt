//#sample-build-sbt

name := "file-association-javafx-simple"

organization := "com.quadstingray"

version := "0.1"

scalaVersion := "2.12.8"

enablePlugins(JavaFxPlugin)

javaFxMainClass := "com.quadstingray.javafx.sample.HelloApp"

javaFxFileAssociations += FileAssociation("avi", "video/x-msvideo", "AVI Files")
javaFxFileAssociations += FileAssociation("mov", "video/quicktime", "Mov Files")

//#sample-build-sbt

//#for-debug-activate
javaFxVerbose := true
//#for-debug-activate

javaFxNativeBundles := "image"

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
