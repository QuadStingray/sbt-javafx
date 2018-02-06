//#sample-build-sbt

name := "file-association-javafx-simple"

organization := "com.quadstingray"

version := "0.1"

scalaVersion := "2.12.4"

enablePlugins(JavaFxPlugin)

javaFxMainClass := "com.quadstingray.javafx.sample.HelloApp"

javaFxFileAssociations += FileAssociation("avi", "video/x-msvideo", "AVI Files")
javaFxFileAssociations += FileAssociation("mov", "video/quicktime", "Mov Files")

//#sample-build-sbt

javaFxNativeBundles := "image"
