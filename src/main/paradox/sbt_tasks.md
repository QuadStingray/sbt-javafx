# SBT Tasks

## javaFxPackage
This is the main task you use to build your application and build it into the desired native packages. The task uses the two tasks listed below to build the application. The packaged application you can find inside `target/<scala-version>/<artifact-name>/`, e.g.
`target/scala-2.12/my_javafx_application_2.12.4-1.0.2/`. (It is possible to customize the name of the directory.)
```shell
sbt javaFxPackage
```

## javaFxPrepareBuild
First the sbt task compile is executed, then the file build.xml is created in the compile target directory based on the settings. You can use the task to debug and check the `build.xml`.
```shell
sbt javaFxPrepareBuild
```

## javaFxRunBuild
Build the JavaFx application based on the generated `build.xml` and compiled `*.class` files.
```shell
sbt javaFxRunBuild
```

@@@ note { .tip title="Manually edit build.xml" }

To experiment with JavaFX packaging options that are not (yet) supported by the plugin, you can manually edit the intermediate version of the `build.xml` file.

@@@