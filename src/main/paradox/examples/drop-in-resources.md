# Drop-in-Resources

## Add files to Directory for drop in
Default
: @@snip [build.sbt](../../../sbt-test/mac/drop-in/build.sbt){#sample-dropinresources-build-sbt}

Changed Directory
: @@snip [build.sbt](../../../sbt-test/mac/drop-in-change-dir/build.sbt){#sample-dropinresources-changed-build-sbt}

@@@ warning { .tip title="Change SBT Key" }
In Version 1.3.0 the SBT Key is renamed from `javaFxPkgResourcesDir` to `javaFxPkgResourcesPath`.
@@@

## Directory Structure

Default
: @@snip [filelist](drop-in-resources/filelist.txt)

Changed Directory
: @@snip [filechanged](drop-in-resources/filechanged.txt)


## /project/plugin.sbt
@@@ vars
```sbt
addSbtPlugin("com.quadstingray" % "sbt-javafx" % "$project.version$")
```
@@@

## For debug activate
@@snip [build.sbt](../../../sbt-test/mac/drop-in-change-dir/build.sbt){#for-debug-activate}



