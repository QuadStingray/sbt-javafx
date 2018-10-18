# Java 11 Support
The Plugin is ready to use with Java 11. There are some small information for building your JavaFx Application with Java 11.

## JavaFX Ant Jar
At Java 11 the Jar `ant-javafx.jar` is not included any more. So when you can use your own ant-javafx.jar or we download an ant jar at the build process from the antjar-change test.

## Java Home
When you have more than one installations of Java on your device, you can change the JavaHome Path by adding:
```scala
  javaFxJavaHome := "/path/to/individual/java/home"
```