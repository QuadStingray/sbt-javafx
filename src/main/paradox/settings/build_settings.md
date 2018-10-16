# Build Process Settings

## Java Home
Self-contained applications must be packaged with the JDK version of the JRE, not the stand-alone JRE. (On Windows, you probably have both installed if you have the JDK installed.) If you try to use the JRE version, you will get the error message "jvm.dll not found". By
default the plugin use the `JAVA_HOME` to choose the JDK.

Default: System.getProperty("java.home")

Individual Java Home
```scala
  javaFxJavaHome := "/path/to/individual/java/home"
```

# Ant JavaFx Jar
At Java 11 the Jar `ant-javafx.jar` is not included any more. So when you are using Java 11 or you want use an alternativ Jar you can do it with that setting.

Default: System.getProperty("java.home") + "/../lib/ant-javafx.jar"
```scala
  javaFxAntPath := "/path/to/individual/ant-javafx.jar"
```

## Log Build Output to Console
To debug the packaging process, set `javaFxVerbose := true` in your `build.sbt` file. Default the value is `false`

## Java-only application
If the JavaFx application does not use Scala classes then the option `javaFxJavaOnly := true` can be set. This option excludes the Scala Standard Jars and the package will be slightly smaller at the end.

## Artifact Name
Pattern: artifact.value.name_scalaVersion.value-projectID.value.revision
Default: my_javafx_application_2.12.7-1.0.2
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