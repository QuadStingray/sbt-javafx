lazy val unusedWarnings = Seq("-Ywarn-unused-import", "-Ywarn-unused")

lazy val commonSettings: Seq[Setting[_]] = Seq(
  organization in ThisBuild := "com.quadstingray",
  homepage := Some(url("https://github.com/QuadStingray/sbt-javafx")),
  licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html")),
  description in ThisBuild := "Sbt plugin for building JavaFx Applications",
  developers in ThisBuild := List(
    Developer("QuadStingray", "QuadStingray", "github@quadstingray.com", url("https://github.com/QuadStingray"))
  ),
  scmInfo in ThisBuild := Some(ScmInfo(url("https://github.com/QuadStingray/sbt-javafx"), "https://github.com/QuadStingray/sbt-javafx.git")),
  scalaVersion := (crossScalaVersions in ThisBuild).value.last,
  scalacOptions ++= Seq(Opts.compile.deprecation, "-Xlint", "-feature"),
  scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)) {
    case Some((2, v)) if v >= 11 => unusedWarnings
  }.toList.flatten,
  publishArtifact in Test := false,
  bintrayRepository := "sbt-plugins",
  bintrayPackage := "sbt-javafx"
) ++ Seq(Compile, Test).flatMap(c =>
  scalacOptions in(c, console) --= unusedWarnings
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "sbt-javafx",
    sbtPlugin := true,
    crossSbtVersions := List("1.1.0"),
    scalaVersion := (CrossVersion partialVersion sbtCrossVersion.value match {
      case Some((0, 13)) => "2.10.6"
      case Some((1, _)) => "2.12.4"
      case _ => sys error s"Unhandled sbt version ${sbtCrossVersion.value}"
    }),
    libraryDependencies ++= Seq(
      "org.foundweekends" %% "bintry" % "0.5.1",
      "org.slf4j" % "slf4j-nop" % "1.7.7", // https://github.com/sbt/sbt-bintray/issues/26
      "org.apache.ant" % "ant" % "1.10.1"),
    resolvers += Resolver.sonatypeRepo("releases"),
    resolvers += Resolver.jcenterRepo
  )

val sbtCrossVersion = sbtVersion in pluginCrossBuild
