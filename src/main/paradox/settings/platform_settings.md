# Platform Settings
Defines application platform requirements. [Oracle JavaFX documentation](https://docs.oracle.com/javafx/2/deployment/javafx_ant_task_reference.htm#CIAEEFCJ)


## Minimum JavaFX
Minimum version of JavaFX required by the application. [Oracle JavaFX documentation](https://docs.oracle.com/javafx/2/deployment/javafx_ant_task_reference.htm#CIAEEFCJ)
```scala
javaFxJavafx := Some("8.0")
```

## Minimum JRE
Minimum version of JRE required by the application. [Oracle JavaFX documentation](https://docs.oracle.com/javafx/2/deployment/javafx_ant_task_reference.htm#CIAEEFCJ)
```scala
javaFxJ2se := Some("8.0")
```

## JVA Args
The JVM argument to be set in the JVM, where the application is executed. [Oracle JavaFX documentation](https://docs.oracle.com/javafx/2/deployment/javafx_ant_task_reference.htm#CIAHJIJG)
```scala
javaFxJvmargs ++= Seq("-Xmx64g", "-Dorg.apache.deltaspike.ProjectStage=Production")
```

## JVM User Args
The user overridable JVM argument to be set in the JVM, where the application is executed. [Oracle JavaFX documentation](https://docs.oracle.com/javafx/2/deployment/javafx_ant_task_reference.htm#CIAHJIJG)
```scala
javaFxJvmuserargs += "-Xmx" -> "768m"
```

## Properties
Optional element and can be used multiple times. Java property to be set in the JVM where the application is executed. [Oracle JavaFX documentation](https://docs.oracle.com/javafx/2/deployment/javafx_ant_task_reference.htm#CIAHCIFJ)
```scala
javaFxProperties += "mySpecialKey" -> "Sample Value"
```
