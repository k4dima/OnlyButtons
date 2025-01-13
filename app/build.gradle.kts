plugins {
    alias(libs.plugins.testioApplication)
    alias(libs.plugins.kotlinSerialization)
}
android {
    namespace = "com.example.onlybuttons"
    signingConfigs {
        create("release") {
            keyAlias = "key0"
            keyPassword = "buttons"
            storeFile = file("release.keystore")
            storePassword = "buttons"
        }
    }
    defaultConfig {
        signingConfig = signingConfigs.getByName("release")
    }
}
dependencies {
    // k4dima
    implementation(libs.design)
    // kotlin
    implementation(tlibs.kotlinx.serialization.json)
}