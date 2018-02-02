# Application Settings

The following keys allow you to specify additional metadata for the installer and the application manifest. Details can be found in the [fx:info JavaFX Ant Task Reference](http://docs.oracle.com/javafx/2/deployment/javafx_ant_task_reference.htm#CIAIEJHG).

## Main Class
Default: (mainClass in Compile).value
```scala
javaFxMainClass := "com.example.MainClass"
```

## Vendor
```scala
javaFxVendor := "ABC Inc."
```

## Title
Default: name.value
```scala
javaFxTitle := "My Cool New Application"
```

## App Version
Default: version.value
```scala
javaFxAppVersion := "1.0.0-BETA"
```

## Category
```scala
javaFxCategory := "Tutorial"
```
## Description
Default: description.value
```scala
javaFxDescription := "What the App does."
```

## Copyright
```scala
javaFxCopyright := "ABC Inc. 2018"
```
## License
Default: head of licenses.value
```scala
javaFxLicense := "Apache-2.0"
```

## Width
Default: 800
```scala
javaFxWidth := 800
```

## Height
Default: 800
```scala
javaFxHeight := 800
```

## Embedded Width
Default: "100%"
```scala
javaFxEmbeddedWidth := "100%"
```

## Embedded Height
Default: "100%"
```scala
javaFxEmbeddedHeight := "100%"
```

## File Associations
Associates file extensions or MIME types with a self-contained application. See also [Oracle JavaFX documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/deploy/javafx_ant_task_reference.html#CIAIDHBJ)
```scala
import com.quadstingray.sbt.javafx.model.FileAssociation

javaFxFileAssociations ++= Seq(FileAssociation("js", "text/javascript", "JavaScript Source"))

javaFxFileAssociations += FileAssociation("groovy", "", "")
```
