package com.quadstingray.sbt.javafx.model

case class JavaFxBuildPaths(devKit: JavaDevKit, jfxrt: String, antLib: String, pkgResourcesDir: String)


case class TemplateSettings(file: Option[sbt.File], destFile: Option[sbt.File], placeholderId: String)

case class Permissions(elevated: Boolean, cacheCertificates: Boolean)


case class AppDimensions(width: Int, height: Int, embeddedWidth: String, embeddedHeight: String)






