//#sample-build-sbt
name := "sbt-javafx-simple"

organization := "com.quadstingray"

version := "0.1"

scalaVersion := "2.12.4"

enablePlugins(JavaFxPlugin)

javaFxMainClass := "com.quadstingray.javafx.sample.HelloApp"

//#sample-build-sbt

//#for-debug-activate
javaFxVerbose := true
//#for-debug-activate

javaFxNativeBundles := "image"
