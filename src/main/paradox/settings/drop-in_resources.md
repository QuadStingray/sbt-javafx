#### Drop-in Resources
The native Packages for your platform can be customized. The Ant-Tasks `fx:deploy` `ant-javafx.jar` is not very flexible to specify of these "drop-in" resources, so tweaking an installer can be frustrating the first time around. Any encountered problems are likely
to be associated with mis-named or mis-located files.

At the heart of the process of specifying the location of drop-in resources is ensuring the classpath of the ClassLoader executing `fx:deploy` can resolve the desired resources. The plugin provides the `javaFxPkgResourcesDir` setting for prepending a path
to the `fx:deploy` classpath (which is *not* the same as the SBT classpath or the `scalac` classpath).

Default value:
```scala
javaFxPkgResourcesPath := (baseDirectory.value / "src/deploy").getAbsolutePath
```

See the [Oracle Java Fx Drop In Resources Documentation](https://docs.oracle.com/javafx/2/deployment/self-contained-packaging.htm#BCGICFDB) for specifics, but the basic structure is `package/{macosx,windows,linux}/[drop-in-resources]`.

Example of Drop-In Files:

* `src/deploy/package/macosx/Info.plist` for a custom `Info.plist` file on MacOS X
* `src/deploy/package/macosx/Application Name.icns` for a custom Application Icon file on MacOS X
* `src/deploy/package/windows/Application Name.ico` for a custom Application Icon on Windows


For debugging the build task with output for a list of customizable files use: @ref[javaFxVerbose](build_settings.md#log-build-output-to-console)
