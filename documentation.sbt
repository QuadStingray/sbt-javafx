import scala.sys.process._

val lastVersionString = "git tag -l".!!.split("\r?\n").last

version in Paradox := {
  if (isSnapshot.value)
    lastVersionString
  else version.value
}

paradoxProperties += ("app-version" -> {
  if (isSnapshot.value)
    lastVersionString
  else version.value
})

enablePlugins(ParadoxSitePlugin, ParadoxMaterialThemePlugin)

sourceDirectory in Paradox := sourceDirectory.value / "main" / "paradox"

ParadoxMaterialThemePlugin.paradoxMaterialThemeSettings(Paradox)

paradoxMaterialTheme in Paradox ~= {
  _.withRepository(uri("https://github.com/QuadStingray/sbt-javafx"))
}

enablePlugins(SiteScaladocPlugin)

enablePlugins(GhpagesPlugin)

git.remoteRepo := "https://$GITHUB_USERNAME:$GITHUB_API_KEY@github.com/QuadStingray/sbt-javafx.git"

ghpagesNoJekyll := true
