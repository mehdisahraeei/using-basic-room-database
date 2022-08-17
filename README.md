

## Gradle


### step1
add the dependency in your build.gradle.

```
    def room_version = "2.2.5"

    implementation "android.arch.lifecycle:extensions:1.1.0"
    implementation "androidx.room:room-runtime:$room_version"
    implementation "androidx.room:room-rxjava2:$room_version"
    implementation "androidx.room:room-guava:$room_version"

    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel:2.3.1"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata:2.3.1"


    annotationProcessor "androidx.room:room-compiler:$room_version"
    testImplementation "androidx.room:room-testing:$room_version"

```
