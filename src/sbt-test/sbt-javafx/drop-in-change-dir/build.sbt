//#sample-dropinresources-changed-build-sbt
name := "DropInResourcesChanged"

organization := "com.quadstingray"

version := "0.1"

scalaVersion := "2.12.7"

enablePlugins(JavaFxPlugin)

mainClass := Option("com.quadstingray.javafx.sample.HelloApp")

javaFxPkgResourcesPath := (baseDirectory.value / "src/change").getAbsolutePath

//#sample-dropinresources-changed-build-sbt

//#for-debug-activate
javaFxVerbose := true
//#for-debug-activate

//#sample-native-bundles
javaFxNativeBundles := "image"
//#sample-native-bundles
