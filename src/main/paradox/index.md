# sbt-javafx
## Build Informations
 [ ![Download](https://api.bintray.com/packages/quadstingray/sbt-plugins/sbt-javafx/images/download.svg) ](https://bintray.com/quadstingray/sbt-plugins/sbt-javafx/_latestVersion)
 [![Build Status](https://travis-ci.org/QuadStingray/sbt-javafx.svg?branch=master)](https://travis-ci.org/QuadStingray/sbt-javafx)


## Quick start
Add an `plugins.sbt` to the project's `project` directory, with the
following content:

```scala
addSbtPlugin("com.quadstingray" % "sbt-javafx" % "0.9.0")
```

add to `build.sbt` file (e.g. `build.sbt`) :

```scala
enablePlugins(JavafxPlugin)

javaFxMainClass := "com.example.MainClass"
```

To package the application, simply run the `sbt javaFxPackage`.

## maven

sbt-javafx is deployed on bintray (jcenter).

## Licence

[Apache 2 License.](https://github.com/QuadStingray/sbt-javafx/blob/master/LICENSE)


## Todos:
- Tests
- Documentation


@@@ index

* [Enabling the plugin](index.md)
* [Running from within SBT](index.md)
* [Customizing paths to necessary JavaFX files](index.md)
* [Packaging](index.md)
* [Other settings](index.md)
* [Advanced features](index.md)
* [Examples](index.md)

@@@