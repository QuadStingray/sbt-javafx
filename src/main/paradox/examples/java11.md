# Java 11 Support
The Plugin is ready to use with Java 11. There are some small informations for building your JavaFx Application with Java 11.

## JavaFX Ant Jar
At Java 11 the Jar `ant-javafx.jar` is not included any more. So when you are using Java 11 or you want use an alternativ Jar you can do it with that setting.
* Download javafx-ant-jar and add to project.
* Add to build.sbt @@snip [build.sbt](https://github.com/QuadStingray/sbt-javafx/blob/master/src/sbt-test/sbt-javafx/antjar-change/build.sbt) { #alternativ-ant-path }
* More information: @ref[javafxant-jar](javafx-ant-jar.md)

## Java Home
When you have multible installations of Java on your device, you can change the JavaHome Path by adding:
```scala
  javaFxJavaHome := "/path/to/individual/java/home"
```