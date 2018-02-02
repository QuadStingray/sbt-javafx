# Build Process Settings

## JDK or SDK
Self-contained applications must be packaged with the JDK version of the JRE, not the stand-alone JRE. (On Windows, you probably have both installed if you have the JDK installed.) If you try to use the JRE version, you will get the error message "jvm.dll not found". By
default the plugin use the `JAVA_HOME` to choose the JDK.

Default: JDK(System.getProperty("java.home") + "/..")

Individual JDK
```scala
  javaFxDevKit := JDK("/path/to/individual/sdk")
```

Individual SKD
```scala
  javaFxDevKit := SDK("/path/to/individual/sdk")
```

@@@ note { .tip title="Tip" }

SBT does not limit you to using only a single .sbt build settings file for your project. Instead, the settings of all the .sbt files in the root of the project are combined. It's a good idea to leave the path configuration settings in a separate file as the main build
file and to exclude that file from version control, especially if you collaborate with others in the project or compile on different machines for other reasons. The paths may not be equal. (Note that SBT seems to load the .sbt files in alphabetical order, which is
sometimes important ...)

@@@


## Log Build Output to Console
To debug the packaging process, set `javaFxVerbose := true` in your `build.sbt` file. Default the value is `false`

## Java-only application
If the JavaFx application does not use Scala classes then the option `javaFxJavaOnly := true` can be set. This option excludes the Scala Standard Jars and the package will be slightly smaller at the end.

## Artifact Name
Pattern: artifact.value.name_scalaVersion.value-projectID.value.revision
Default: my_javafx_application_2.12.4-1.0.2
```scala
javaFxArtifactName := List(Some(artifact.value.name), Some("_" + scalaVersion.value), Some("-" + projectID.value.revision)).flatten.mkString
```

## Convert CSS to binary
Used to convert CSS files to binary format for faster processing. See also [Oracle JavaFX documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/deploy/packaging.html#BABCACBD)
```scala
javaFxCssToBin := true
```


## Post Process
After successfully building the application, you can run an individual post process, e.g. create a zip file or copy the generated files somewhere...

Example:
```scala
def postProcess(): Unit = {
  println("do something")
}

javaFxPostProcess := postProcess
```

## Template Settings
Template to preprocess. A template is an HTML file that contains markers to be replaced with the JavaScript or HTML snippets that are required for web deployment. Using templates enables you to deploy your application directly into your own web pages. This simplifies
the development process, especially when the application is tightly integrated with the page, for example when the web page uses JavaScript to communicate to the application.
https://docs.oracle.com/javase/8/docs/technotes/guides/deploy/javafx_ant_task_reference.html#CIACACDA

"javafx" is the name of

```scala
javaFxTemplate := TemplateSettings(Some(new sbt.File("src/templates/EmbedApp_template.html")),Some(new sbt.File("dest/templates/EmbedApp_template.html")))
```