
name := "sbt-javafx"

organization := "com.quadstingray"

homepage := Some(url("https://quadstingray.github.io/sbt-javafx/"))

scmInfo := Some(ScmInfo(url("https://github.com/QuadStingray/sbt-javafx"), "https://github.com/QuadStingray/sbt-javafx.git"))

developers := List(Developer("QuadStingray", "QuadStingray", "github@quadstingray.com", url("https://github.com/QuadStingray")))

licenses += ("Apache-2.0", url("https://github.com/QuadStingray/sbt-javafx/blob/master/LICENSE"))

description := "Sbt plugin for building JavaFx Applications"

publishMavenStyle := false

bintrayReleaseOnPublish in ThisBuild := true

scalaVersion := "2.12.7"

crossSbtVersions := Vector("0.13.17", "1.2.4")

scalacOptions ++= Seq("-deprecation", "-feature")

initialCommands in console := "import com.quadstingray.sbt.javafx._"

libraryDependencies += "org.apache.ant" % "ant" % "1.10.5"

resolvers += Resolver.sonatypeRepo("releases")

resolvers += Resolver.jcenterRepo

import sbtrelease.ReleasePlugin.autoImport.ReleaseTransformations._

releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies, // : ReleaseStep
    inquireVersions, // : ReleaseStep
    setReleaseVersion, // : ReleaseStep
    commitReleaseVersion, // : ReleaseStep, performs the initial git checks
    tagRelease, // : ReleaseStep
    setNextVersion, // : ReleaseStep
    commitNextVersion, // : ReleaseStep
    pushChanges // : ReleaseStep, also checks that an upstream branch is properly configured
)
