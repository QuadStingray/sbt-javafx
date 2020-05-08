
name := "sbt-javafx"

organization := "com.quadstingray"

homepage := Some(url("https://quadstingray.github.io/sbt-javafx/"))

scmInfo := Some(ScmInfo(url("https://github.com/QuadStingray/sbt-javafx"), "https://github.com/QuadStingray/sbt-javafx.git"))

developers := List(Developer("QuadStingray", "QuadStingray", "github@quadstingray.com", url("https://github.com/QuadStingray")))

licenses += ("Apache-2.0", url("https://github.com/QuadStingray/sbt-javafx/blob/master/LICENSE"))

description := "Sbt plugin for building JavaFx Applications"

publishMavenStyle := false

bintrayReleaseOnPublish in ThisBuild := true

scalaVersion := crossScalaVersions.value.last

crossScalaVersions := List("2.12.1")

scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-Ywarn-unused", "-Yrangepos")

crossSbtVersions := Vector("1.3.10")

initialCommands in console := "import com.quadstingray.sbt.javafx._"

libraryDependencies += "org.apache.ant" % "ant" % "1.10.7"

resolvers += Resolver.sonatypeRepo("releases")

resolvers += Resolver.jcenterRepo

import sbtrelease.ReleasePlugin.autoImport.ReleaseTransformations._

releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies, // : ReleaseStep
    inquireVersions, // : ReleaseStep
    setReleaseVersion, // : ReleaseStep
    commitReleaseVersion, // : ReleaseStep, performs the initial git checks
    tagRelease, // : ReleaseStep
    publishArtifacts,
    setNextVersion, // : ReleaseStep
    commitNextVersion, // : ReleaseStep
    pushChanges // : ReleaseStep, also checks that an upstream branch is properly configured
)
