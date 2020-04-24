val pluginVersion = System.getProperty("plugin.version")
//val pluginVersion = "1.0.0-SNAPSHOT"
if (pluginVersion == null)
  throw new RuntimeException("""|The system property 'plugin.version' is not defined.
       |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
else {
  addSbtPlugin("com.quadstingray" % "sbt-javafx" % pluginVersion)
}
