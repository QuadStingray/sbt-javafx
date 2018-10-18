# Java 11 Support
The Plugin is ready to use with Java 11. There are some small informations for building your JavaFx Application with Java 11.

## JavaFX Ant Jar
At Java 11 the Jar `ant-javafx.jar` is not included any more. So when you can use your own ant-javafx.jar or we download an ant jar at the build process from the antjar-change test.

## build.sbt
You need the OpenJFX Framework in you projekt. For example:
```sbt
  val osName: SettingKey[String] = SettingKey[String]("osName")
  
  osName := (System.getProperty("os.name") match {
    case name if name.startsWith("Linux") => "linux"
    case name if name.startsWith("Mac") => "mac"
    case name if name.startsWith("Windows") => "win"
    case _ => throw new Exception("Unknown platform!")
  })
  
  libraryDependencies += "org.openjfx" % "javafx-base" % "11" classifier osName.value
```

## Java Home
When you have multible installations of Java on your device, you can change the JavaHome Path by adding:
```scala
  javaFxJavaHome := "/path/to/individual/java/home"
```