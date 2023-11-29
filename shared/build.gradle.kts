plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()


    cocoapods {
        summary = "Kotlin sample project with CocoaPods dependencies"
        homepage = "https://github.com/Kotlin/kotlin-with-cocoapods-sample"

        ios.deploymentTarget = "13.5"
        version = "1.0"
//      Example of usage remote Cocoapods dependency from Cocoapods repository
        pod("AFNetworking") {
            version = "~> 4.0.1"
        }

    }
        android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.jetbrains.kmp"
    compileSdk = 34
    defaultConfig {
        minSdk = 28
    }
}