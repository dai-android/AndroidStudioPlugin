
# How use this project first time

1. disable module `app`  in file `settings.gradle`    
2. modify root build.gradle file like follow
```
    dependencies {
        classpath "com.android.tools.build:gradle:$gradle_version"

        // classpath "dai.android.plugin:media:$plugin_media_version"
    }
```
3. execute 
```
gradlew :media-plugin:upload
```
4. open all disable line

