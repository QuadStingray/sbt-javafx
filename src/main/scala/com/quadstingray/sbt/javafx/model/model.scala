package com.quadstingray.sbt.javafx.model

case class JavaFxBuildPaths(javaHome: String, var javafxAntPath: String, pkgResourcesPath: String)

case class TemplateSettings(file: Option[sbt.File], destFile: Option[sbt.File])

case class Permissions(elevated: Boolean, cacheCertificates: Boolean)

case class AppDimensions(width: Int, height: Int, embeddedWidth: String, embeddedHeight: String)
