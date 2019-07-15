# File Association


## build.sbt
@@snip [build.sbt](../../../sbt-test/mac/fileassociation-javafx/build.sbt) { #sample-build-sbt }

## /project/plugin.sbt
@@@ vars
```sbt
addSbtPlugin("com.quadstingray" % "sbt-javafx" % "$project.version$")
```
@@@

## For debug activate
@@snip [build.sbt](../../../sbt-test/mac/fileassociation-javafx/build.sbt){#for-debug-activate}
