# Java 12 Support
The Plugin is ready to use with Java 12. There are some small information for building your JavaFx Application with Java 12.

In Java 12 `libjli.dylib` has moved from `JAVA_HOME/lib` to `JAVA_HOME`. The Ant Task currently checks on `libjli.dylib` on right location. So the Plugin copies the `libjli.dylib` from `JAVA_HOME` to `JAVA_HOME/lib` and remove it after Build Process.