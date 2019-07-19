# sbt-javafx
[SBT](http://www.scala-sbt.org/) (Simple Build Tool) plugin for building JavaFx Application. The plugin is inspired by [Kavedaa Sbt Javafx](https://github.com/kavedaa/sbt-javafx)

## Build Status
[![Download](https://api.bintray.com/packages/quadstingray/sbt-plugins/sbt-javafx/images/download.svg)](https://bintray.com/quadstingray/sbt-plugins/sbt-javafx/_latestVersion)
[![Build Status](https://travis-ci.org/QuadStingray/sbt-javafx.svg?branch=master)](https://travis-ci.org/QuadStingray/sbt-javafx)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/b18d8cb66b5a47f3ad5485c848c5bda7)](https://www.codacy.com/app/QuadStingray/sbt-javafx?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=QuadStingray/sbt-javafx&amp;utm_campaign=Badge_Grade)

## Documentation
[https://quadstingray.github.io/sbt-javafx/](https://quadstingray.github.io/sbt-javafx/)

## Information
This plugin, specifically the Java 12 and 13 support, is currently only tested on Mac. Further tests under Windows and Linux are to follow. If you have a problem with Java 12/13, please open an issue on Github.

**Java 13 Test not running! Looks like SBT on Java 13 Problem**
**Linux Java Version > 9 Issue see [Java 13 Support](https://quadstingray.github.io/sbt-javafx/java/linux.html)**

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
[Java 11 Support](https://quadstingray.github.io/sbt-javafx/java/java11.html)
[Java 12 Support](https://quadstingray.github.io/sbt-javafx/java/java12.html)

## Contributing
If you find this plugin helpfull, so you can see here how you can help:
* Send a pull request with your features and bug fixes
* Help users resolve their [issues](https://github.com/QuadStingray/sbt-javafx/issues).

## maven
sbt-javafx is deployed on bintray (jcenter).

## Version History and Changes
https://quadstingray.github.io/sbt-javafx/versions/index.html

## Licence
[Apache 2 License.](https://github.com/QuadStingray/sbt-javafx/blob/master/LICENSE)
