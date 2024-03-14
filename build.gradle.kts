import com.github.javaparser.utils.Utils.set

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
}

allprojects {
    ext {
        set("retrofitVersion", "2.9.0")
        set("moshiVersion", "1.11.0")
        set("okhttpInterceptorVersion", "4.9.0")
        set("glid", "4.11.0")
        set("activityKtxVersion", "1.2.0-rc01")
    }
}