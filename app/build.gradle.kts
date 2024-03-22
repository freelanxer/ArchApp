plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.freelanxer.archapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.freelanxer.archapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // UI
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    // retrofit
    implementation("com.squareup.retrofit2:converter-moshi:${project.ext.get("retrofitVersion")}")
    implementation("com.squareup.moshi:moshi:${project.ext.get("moshiVersion")}")
    implementation("com.squareup.moshi:moshi-kotlin:${project.ext.get("moshiVersion")}")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:${project.ext.get("moshiVersion")}")
    implementation("com.squareup.okhttp3:logging-interceptor:${project.ext.get("okhttpInterceptorVersion")}")
    implementation("com.github.bumptech.glide:glide:${project.ext.get("glid")}") {
        exclude("com.android.support")
    }
    implementation ("androidx.activity:activity-ktx:${project.ext.get("activityKtxVersion")}")
    // Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.48")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.48")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.48")
    // Coil
    implementation("io.coil-kt:coil:2.6.0")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}