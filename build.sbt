name := "sbt-javafx"

// this bit is important
sbtPlugin := true

organization := "com.quadstingray"

name := "sbt-javafx"

version := "0.5.0"

scalaVersion := "2.12.4"

scalacOptions ++= Seq("-deprecation", "-feature")

resolvers += Resolver.sonatypeRepo("snapshots")

publishMavenStyle := false

/** Console */
initialCommands in console := "import  com.quadstingray.sbt.javafx._"

libraryDependencies += "org.apache.ant" % "ant" % "1.10.1"

libraryDependencies += "com.github.pathikrit" %% "better-files" % "3.4.0"
