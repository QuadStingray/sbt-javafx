# JavaFx Ant Jar
At Java 11 the Jar `ant-javafx.jar` is not included any more. So when you are using Java 11 or you want use an ohter Jar you can do it with that setting.
The plugin checks if the file exists. If the file is not available at the specified location, then the plugin downloads the ant-javafx.jar from our Github repository.

## build.sbt
@@snip [build.sbt](../../../sbt-test/sbt-javafx/antjar-change/build.sbt) { #alternativ-ant-path }

## /project/plugin.sbt
@@@ vars
```sbt
addSbtPlugin("com.quadstingray" % "sbt-javafx" % "$project.version$")
```
@@@
