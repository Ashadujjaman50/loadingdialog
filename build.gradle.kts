plugins {
    alias(libs.plugins.android.library)
    `maven-publish`
}

android {
    namespace = "com.ashadujjaman.loadingdialog"
    compileSdk = 36

    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

repositories {
    google()
    mavenCentral()
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.github.Ashadujjaman50"  // GitHub username
                artifactId = "loadingdialog"          // Module name
                version = "1.0.0"

                // Path to the AAR produced by this library
                artifact("$buildDir/outputs/aar/loadingdialog-release.aar")
            }
        }
    }
}
