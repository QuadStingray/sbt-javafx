sbtPlugin := true

enablePlugins(SbtPlugin)

scriptedLaunchOpts := {
  scriptedLaunchOpts.value ++
    Seq("-Dplugin.version=" + version.value)
}

scriptedBufferLog := false