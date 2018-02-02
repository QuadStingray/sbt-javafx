# Native Bundles

For creating so-called "native bundles", that is, self-contained applications which co-bundles the JRE, use this setting:

```scala
javaFxNativeBundles := bundleString
```
`bundleString` is one of:

* `all` - create all native bundles available on build platform
* `deb` - Debian installer file (Linux only)
* `dmg` - MacOS X disk image (MacOS X only)
* `exe` - Windows stand-alone installer (Windows only)
* `image` - to produce a basic package
* `msi` - Windows "installer database" file (Windows only)
* `none` - Don't make native bundle (default)
* `rpm` - Redhat Package Manager file (Linux only)


See the [Oracle JavaFX packaging documentation](https://docs.oracle.com/javafx/2/deployment/self-contained-packaging.htm#A1308687) for possible values and further information.

@@@ warning { title='Package `dmg`' .bug }

Currently there is an bug in Java Version 8u162, 9 and 10, so that no dmg can be built. See on [stackoverflow.com](https://stackoverflow.com/questions/46515301/icns-file-not-found-error-with-javapackager-on-macos-high-sierra) and
[Bugdatabase Oracle](https://bugs.java.com/bugdatabase/view_bug.do?bug_id=8190758)

@@@
