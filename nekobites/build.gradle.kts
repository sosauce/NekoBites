
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    id("maven-publish")
}

android {
    namespace = "com.sosauce.nekobites"
    compileSdk {
        version = release(37)
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}
dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.animation)
    implementation(libs.androidx.compose.animation.graphics.android)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.colorpicker.compose)

}

publishing {
    publications {
        register<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"])
                groupId = "com.github.sosauce"
                artifactId = "nekobites"
                version = "1.0.0"
            }
        }
    }
}