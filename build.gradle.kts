// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
    // Add the dependency for the App Distribution Gradle plugin
    id("com.google.firebase.appdistribution") version "5.0.0" apply false
    id("org.jetbrains.kotlin.kapt") version "1.9.0" apply false
}