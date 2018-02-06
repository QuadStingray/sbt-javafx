
name := "sbt-javafx"

organization := "com.quadstingray"

homepage := Some(url("https://quadstingray.github.io/sbt-javafx/"))

scmInfo := Some(ScmInfo(url("https://github.com/QuadStingray/sbt-javafx"), "https://github.com/QuadStingray/sbt-javafx.git"))

developers := List(Developer("QuadStingray", "QuadStingray", "github@quadstingray.com", url("https://github.com/QuadStingray")))

licenses += ("Apache-2.0", url("https://github.com/QuadStingray/sbt-javafx/blob/master/LICENSE"))

description := "Sbt plugin for building JavaFx Applications"

sbtPlugin := true

scalaVersion := "2.12.4"

crossSbtVersions := Vector("1.1.0", "1.0.0")

scalacOptions ++= Seq("-deprecation", "-feature")

initialCommands in console := "import com.quadstingray.sbt.javafx._"

libraryDependencies += "org.apache.ant" % "ant" % "1.10.1"

resolvers += Resolver.sonatypeRepo("releases")

resolvers += Resolver.jcenterRepo

publishTo := {
  if (isSnapshot.value)
    Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/.m2/repository/")))
  else
    Some("Bintray API Realm" at "https://api.bintray.com/content/quadstingray/sbt-plugins/%s/%s;publish=1;override=1".format(name.value, version.value))
}

credentials += Credentials(new File("credentials.properties"))

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