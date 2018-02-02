package com.quadstingray.sbt.javafx.model

case class JavaFxBuildPaths(devKit: JavaDevKit, pkgResourcesDir: String)

case class TemplateSettings(file: Option[sbt.File], destFile: Option[sbt.File])

case class Permissions(elevated: Boolean, cacheCertificates: Boolean)

case class AppDimensions(width: Int, height: Int, embeddedWidth: String, embeddedHeight: String)






