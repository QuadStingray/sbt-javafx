# Simple Example


## build.sbt
There are two ways to define the MainClass for your JavaFx Application:

SBT
: @@snip [build.sbt](../../../sbt-test/mac/mainclass-sbt/build.sbt) { #sample-build-sbt }

JavaFX
: @@snip [build.sbt](../../../sbt-test/mac/mainclass-javafx/build.sbt) { #sample-build-sbt }

## /project/plugin.sbt
@@@ vars
```sbt
addSbtPlugin("com.quadstingray" % "sbt-javafx" % "$project.version$")
```
@@@

## For debug activate
@@snip [build.sbt](../../../sbt-test/mac/mainclass-sbt/build.sbt){#for-debug-activate}
