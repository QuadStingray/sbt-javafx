# List of all possible Settings

@@@ note { .tip title="Tip" }

SBT has no limit to use only a single .sbt build settings file for your project. Instead, the settings of all the .sbt files in the root of the project are combined. It's a good idea to leave the path configuration settings in a separate file as the main build file and
to exclude that file from version control, especially if you collaborate with others in the project or compile on different machines for other reasons. The paths may not be equal. (Note that SBT seems to load the .sbt files in alphabetical order, which is sometimes
important ...)

@@@

## Build Process Settings
* @ref[javaFxNativeBundles](native_bundles.md)
* @ref[javaFxPkgResourcesPath](drop-in_resources.md)
* @ref[javaFxHome](build_settings.md#java-home)
* @ref[indiviualAntJar](build_settings.md#ant-javafx-jar)
* @ref[javaFxJavaOnly](build_settings.md#java-only-application)
* @ref[javaFxArtifactName](build_settings.md#artifact-name)
* @ref[javaFxPostProcess](build_settings.md#post-process)
* @ref[javaFxCssToBin](build_settings.md#convert-css-to-binary)
* @ref[javaFxVerbose](build_settings.md#log-build-output-to-console)
* @ref[javaFxTemplate](build_settings.md#template-settings)

## Application Settings
* @ref[javaFxMainClass](application_settings.md#main-class)
* @ref[javaFxVendor](application_settings.md#vendor)
* @ref[javaFxTitle](application_settings.md#title)
* @ref[javaFxAppVersion](application_settings.md#app-version)
* @ref[javaFxCategory](application_settings.md#category)
* @ref[javaFxDescription](application_settings.md#description)
* @ref[javaFxCopyright](application_settings.md#copyright)
* @ref[javaFxLicense](application_settings.md#license)
* @ref[javaFxWidth](application_settings.md#width)
* @ref[javaFxHeight](application_settings.md#height)
* @ref[javaFxEmbeddedWidth](application_settings.md#embedded-width)
* @ref[javaFxEmbeddedHeight](application_settings.md#embedded-height)
* @ref[javaFxFileAssociations](application_settings.md#file-associations)

## Signing Settings
* @ref[javaFxPermissions](signing_settings.md#javafxpermissions)
* @ref[javaFxKeyStore](signing_settings.md#keystore)
* @ref[javaFxStorePass](signing_settings.md#store-password)
* @ref[javaFxSigningAlias](signing_settings.md#signing-alias)
* @ref[javaFxSigningKeyPass](signing_settings.md#keypass)
* @ref[javaFxSigningKeyStoreType](signing_settings.md#keystore-type)

## Platform Settings
* @ref[javaFxJavafx](platform_settings.md#minimum-javafx)
* @ref[javaFxJ2se](platform_settings.md#minimum-jre)
* @ref[javaFxJvmargs](platform_settings.md#jva-args)
* @ref[javaFxJvmuserargs](platform_settings.md#jvm-user-args)
* @ref[javaFxProperties](platform_settings.md#properties)

@@@ index

* [Build Process Settings](build_settings.md)
* [Application Settings](application_settings.md)
* [Native Bundles](native_bundles.md)
* [Drop In Resources](drop-in_resources.md)
* [Platform Settings](platform_settings.md)
* [Signing Settings](signing_settings.md)

@@@