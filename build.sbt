name := "sbt-javafx"

// this bit is important
sbtPlugin := true

organization := "com.quadstingray"

name := "sbt-javafx"

version := "0.6.0"

licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))

scalaVersion := "2.12.4"

crossSbtVersions := Vector("1.0.0", "1.1.0")

scalacOptions ++= Seq("-deprecation", "-feature")

resolvers += Resolver.sonatypeRepo("snapshots")

publishMavenStyle := true

/** Console */
initialCommands in console := "import  com.quadstingray.sbt.javafx._"

libraryDependencies += "org.apache.ant" % "ant" % "1.10.1"

resolvers += Resolver.jcenterRepo

publishTo := {
  if (isSnapshot.value)
    Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/.m2/repository/")))
  else
    Some("Bintray API Realm" at "https://api.bintray.com/content/quadstingray/maven/%s/%s;publish=1;override=1".format(name.value, version.value))
}

credentials += Credentials(new File("credentials.properties"))