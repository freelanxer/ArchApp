// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlin) apply false
    alias(libs.plugins.kapt) apply false
    alias(libs.plugins.dagger.hilt) apply false
    alias(libs.plugins.google.service) apply false
    // Add the dependency for the App Distribution Gradle plugin
    alias(libs.plugins.app.distribution) apply false
}