buildscript {
    extra.apply {
        set("room_version", "2.6.0")
    }
}

plugins {
    id("com.android.application") version "8.1.4" apply false
    id("com.android.library") version "8.1.4" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
    id("com.google.dagger.hilt.android") version "2.47" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false // Google Services
    id("com.google.firebase.crashlytics") version "2.9.9" apply false // Firebase Crashlytics
    id("com.google.firebase.firebase-perf") version "1.4.2" apply false // Firebase Performance Monitoring
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
