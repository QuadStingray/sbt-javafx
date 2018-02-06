package com.quadstingray.sbt

import sbt._
import Keys._

object PluginCompat {
  object CacheImplicits
  val ClasspathUtilities = sbt.classpath.ClasspathUtilities
}