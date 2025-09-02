plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization") version "1.9.10"

}

android {
    namespace = "com.behnamuix.watereto"
    compileSdk = 35
    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        applicationId = "com.behnamuix.watereto"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"




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
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
        kotlinOptions {
            jvmTarget = "11"
        }
        buildFeatures {
            compose = true
        }
    }

    dependencies {

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.material3)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)

        val voyagerVersion = "1.1.0-beta02"

        // Multiplatform

        // Navigator
        implementation(libs.voyager.navigator)


        //COIL
        implementation(libs.coil.compose)
        //KTOR
        implementation("io.ktor:ktor-client-core:2.3.4") // Replace with latest version
// Ktor Client Android engine (OkHttp alternative, but Android-specific)
        implementation("io.ktor:ktor-client-okhttp:2.3.4")
// Serialization (JSON) support
        implementation("io.ktor:ktor-client-content-negotiation:2.3.4")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
        implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")
        //////////////////////////
        implementation("com.orhanobut:hawk:2.0.1")
        implementation("cafe.adriel.voyager:voyager-tab-navigator:1.1.0-beta02")




    }
}