//#sample-build-sbt
name := "javafx-licences-simple"

organization := "com.quadstingray"

version := "0.1"

scalaVersion := "2.12.7"

enablePlugins(JavaFxPlugin)

javaFxMainClass := "com.quadstingray.javafx.sample.HelloApp"

javaFxLicense := "Apache-2.0"

//#sample-build-sbt

//#for-debug-activate
javaFxVerbose := true
//#for-debug-activate

javaFxNativeBundles := "image"
