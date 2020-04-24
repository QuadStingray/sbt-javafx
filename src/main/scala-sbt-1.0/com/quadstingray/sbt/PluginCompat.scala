package com.quadstingray.sbt

object PluginCompat {
  val ClasspathUtilities = sbt.internal.inc.classpath.ClasspathUtilities
  val Using              = sbt.io.Using
}
