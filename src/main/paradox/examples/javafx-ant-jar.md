# JavaFx Ant Jar
At Java 11 the Jar `ant-javafx.jar` is not included any more. So when you are using Java 11 or you want use an alternativ Jar you can do it with that setting.

@@@ note { .tip title="ant-javafx.jar in plugin" } We are looking for an possibility to have the jar at our plugin as fallback. So long your can download an [ant-javafx.jar](/src/sbt-test/sbt-javafx/antjar-change/alternativ/path/ant-javafx.jar) here. You can add the jar
file to your project and than you can use an relative path like in our example. @@@

## build.sbt
@@snip [build.sbt](../../../sbt-test/sbt-javafx/antjar-change/build.sbt) { #alternativ-ant-path }

## /project/plugin.sbt
@@@ vars
```sbt
addSbtPlugin("com.quadstingray" % "sbt-javafx" % "$project.version$")
```
@@@
