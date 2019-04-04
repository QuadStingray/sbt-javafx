# sbt-javafx
[SBT](http://www.scala-sbt.org/) (Simple Build Tool) plugin for building JavaFx Application. The plugin is inspired by [Kavedaa Sbt Javafx](https://github.com/kavedaa/sbt-javafx)

## Build Status
[![Download](https://api.bintray.com/packages/quadstingray/sbt-plugins/sbt-javafx/images/download.svg)](https://bintray.com/quadstingray/sbt-plugins/sbt-javafx/_latestVersion)
[![Build Status](https://travis-ci.org/QuadStingray/sbt-javafx.svg?branch=master)](https://travis-ci.org/QuadStingray/sbt-javafx)

## Documentation
https://quadstingray.github.io/sbt-javafx/

## Quick start
Add an `plugins.sbt` to the project's `project` directory, with the following content:

```scala
addSbtPlugin("com.quadstingray" % "sbt-javafx" % "X.Y.Z")
```

add to `build.sbt` file (e.g. `build.sbt`) :

```scala
enablePlugins(JavaFxPlugin)

javaFxMainClass := "com.example.MainClass"
```

To package the application, simply run the `sbt javaFxPackage`.

## How to use Plugin with Java 11
[Java 11 Example](https://quadstingray.github.io/sbt-javafx/examples/java11.html)

## Contributing
If you find this plugin helpfull, so you can see here how you can help:
  - Send a pull request with your features and bug fixes
  - Help users resolve their [issues](https://github.com/QuadStingray/sbt-javafx/issues).

## maven
sbt-javafx is deployed on bintray (jcenter).

## Version History and Changes
https://quadstingray.github.io/sbt-javafx/versions/index.html

## Licence
[Apache 2 License.](https://github.com/QuadStingray/sbt-javafx/blob/master/LICENSE)
