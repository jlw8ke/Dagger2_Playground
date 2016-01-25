# Fire_Starter_Android

This application provides a sample of setting up an android project with the following components.

* Dagger (v1)
* Retrofit and OkHttp
* Otto 
* Robolectric 3.0
* QA Testing (Mobile eXplorer)

## Setup
<hr/>
Ensure that the following is installed

* Gradle v2.3
* Android Bulid Tools v22
* Android SDK v22

The application can be loaded into android studio through importing `settings.gradle`



## Building
<hr/>
### Build Flavors
The application contains configuration three build variants: `baseDebug, baseRelease, and qaTestDebug`.  The qaTestRelease build has been configured to compile dispay the Mobile eXplorer widget for testing.

Each build variant can be assembled using the appropriate `assemble<build_variant>` gradle task.
Ex. `assembleQaTestDebug` will assemble the `qaTestDebug` build variant.

#### Release Build
The release build looks for a `sign.properties` at the project's root directory.  This file contains the location of the keystore and necessary signing passwords for a release build.

Sample sign.properties

```
storeFile=my_keystore_loc.keystore
storePassword=my_keystore_password
keyAlias=my_key_alias
keyPassword=my_key_password
```
