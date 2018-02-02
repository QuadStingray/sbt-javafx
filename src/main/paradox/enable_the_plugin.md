# Quick Start

## Enable the Plugin
Add an `plugins.sbt` to the project's `project` directory, with the
following content:

@@@ vars
```sbt
addSbtPlugin("com.quadstingray" % "sbt-javafx" % "$project.version$")
```
@@@


Add to `build.sbt` file:
```sbtshell
enablePlugins(JavaFxPlugin)
```

## Some basic settings
### javaFxMainClass
Once the plugin is activated in the `build.sbt`, the build task can be used with the default values. Without extra configuration the TaskKey mainClass is used for the JavaFx application. But it is also possible to set the main class separately in the `build.sbt`:
```sbtshell
javaFxMainClass := "com.example.MainClass"
```

### javaFxVerbose
By default the Plugin doesn't log any information about the running build. If you want an visual response while building the application you can enable logging to sbt console:
```sbtshell
javaFxVerbose := false
```

