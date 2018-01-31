// version in Paradox := {
//     if (isSnapshot.value)
//         lastVersionString
//     else version.value
// }
//
// paradoxProperties += ("app-version" -> {if (isSnapshot.value)
//     lastVersionString
// else version.value})
//
// enablePlugins(ParadoxSitePlugin, ParadoxMaterialThemePlugin)
// sourceDirectory in Paradox := sourceDirectory.value / "main" / "paradox"
// ParadoxMaterialThemePlugin.paradoxMaterialThemeSettings(Paradox)
//
// paradoxMaterialTheme in Paradox ~= {
//     _.withRepository(uri("https://github.com/sfxcode/sapphire-core"))
// }
//
// // enablePlugins(SiteScaladocPlugin)
//
// enablePlugins(GhpagesPlugin)
//
// git.remoteRepo := "git@github.com:sfxcode/ssapphire-core.git"
// ghpagesNoJekyll := true
//