# Usage in Lunux

## JDK 10 or later

### Known Issue

@@@ error
The current Java FX Ant task does't find libvm.so and lib/rt.jar at linux system.
@@@

```
[info] antProject.message: com.oracle.tools.packager.ConfigException: Java Runtime does not include [lib/[^/]+/[^/]+/libjvm.so, lib/rt.jar]
[info] 	at com.oracle.tools.packager.AbstractImageBundler.testRuntime(AbstractImageBundler.java:78)
[info] 	at com.oracle.tools.packager.linux.LinuxAppBundler.doValidate(LinuxAppBundler.java:155)
[info] 	at com.oracle.tools.packager.linux.LinuxDebBundler.validate(LinuxDebBundler.java:249)
[info] 	at com.sun.javafx.tools.packager.PackagerLib.generateNativeBundles(PackagerLib.java:351)
[info] 	at com.sun.javafx.tools.packager.PackagerLib.generateDeploymentPackages(PackagerLib.java:319)
[info] 	at com.sun.javafx.tools.ant.DeployFXTask.execute(DeployFXTask.java:286)
[info] 	at org.apache.tools.ant.UnknownElement.execute(UnknownElement.java:292)
[info] 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
[info] 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
[info] 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
[info] 	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
[info] 	at org.apache.tools.ant.dispatch.DispatchUtils.execute(DispatchUtils.java:99)
[info] 	at org.apache.tools.ant.Task.perform(Task.java:350)
[info] 	at org.apache.tools.ant.Target.execute(Target.java:449)
[info] 	at org.apache.tools.ant.Target.performTasks(Target.java:470)
[info] 	at org.apache.tools.ant.Project.executeSortedTargets(Project.java:1391)
[info] 	at org.apache.tools.ant.Project.executeTarget(Project.java:1364)
[info] 	at com.[secure].sbt.javafx.SbtTaskManager.runBuild(SbtTaskManager.scala:100)
[info] 	at com.[secure].sbt.JavaFxPlugin$autoImport$.$anonfun$javaFxPluginTasks$3(JavaFxPlugin.scala:29)
[info] 	at com.[secure].sbt.JavaFxPlugin$autoImport$.$anonfun$javaFxPluginTasks$3$adapted(JavaFxPlugin.scala:26)
[info] 	at scala.Function1.$anonfun$compose$1(Function1.scala:44)
[info] 	at sbt.internal.util.$tilde$greater.$anonfun$$u2219$1(TypeFunctions.scala:40)
[info] 	at sbt.std.Transform$$anon$4.work(System.scala:67)
[info] 	at sbt.Execute.$anonfun$submit$2(Execute.scala:269)
[info] 	at sbt.internal.util.ErrorHandling$.wideConvert(ErrorHandling.scala:16)
[info] 	at sbt.Execute.work(Execute.scala:278)
[info] 	at sbt.Execute.$anonfun$submit$1(Execute.scala:269)
[info] 	at sbt.ConcurrentRestrictions$$anon$4.$anonfun$submitValid$1(ConcurrentRestrictions.scala:178)
[info] 	at sbt.CompletionService$$anon$2.call(CompletionService.scala:37)
[info] 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[info] 	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:514)
[info] 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[info] 	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
[info] 	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
[info] 	at java.base/java.lang.Thread.run(Thread.java:844)
[info] antProject.message: Bundler DEB Installer skipped because of a configuration problem: Java Runtime does not include [lib/[^/]+/[^/]+/libjvm.so, lib/rt.jar]  
```