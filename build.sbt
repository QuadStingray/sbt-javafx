name := "sbt-javafx"

// this bit is important
sbtPlugin := true

organization := "com.quadstingray"

name := "sbt-javafx"

version := "0.5.0"

scalaVersion := "2.12.4"

crossSbtVersions := Vector("1.0.0", "1.1.0")

scalacOptions ++= Seq("-deprecation", "-feature")

resolvers += Resolver.sonatypeRepo("snapshots")

publishMavenStyle := false

/** Console */
initialCommands in console := "import  com.quadstingray.sbt.javafx._"

libraryDependencies += "org.apache.ant" % "ant" % "1.10.1"

libraryDependencies += "com.github.pathikrit" %% "better-files" % "3.4.0"

resolvers += Resolver.jcenterRepo

publishTo := {
  if (isSnapshot.value)
    Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/.m2/repository/")))
  else
    Some("Bintray API Realm" at "https://api.bintray.com/content/quadstingray/maven/%s/%s/publish".format(name.value, version.value))
}

credentials += Credentials(new File("credentials.properties"))