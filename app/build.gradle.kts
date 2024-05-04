plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.devtools.ksp")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.devrachit.aiwonderland"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.devrachit.aiwonderland"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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

    implementation ("com.google.dagger:hilt-android:2.50")
    ksp("com.google.dagger:hilt-compiler:2.50")

    androidTestImplementation  ("com.google.dagger:hilt-android-testing:2.50")
    kspAndroidTest("com.google.dagger:hilt-compiler:2.50")

    testImplementation ("com.google.dagger:hilt-android-testing:2.50")
    kspTest ("com.google.dagger:hilt-compiler:2.50")

    val nav_version = "2.7.7"
    implementation("androidx.navigation:navigation-compose:$nav_version")

    // For compose navigation testing
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    // CameraX
    val cameraxVersion = "1.3.0-alpha06"
    implementation("androidx.camera:camera-camera2:$cameraxVersion")
    implementation("androidx.camera:camera-lifecycle:$cameraxVersion")
    implementation("androidx.camera:camera-view:$cameraxVersion")

    //text recognition mlkit
    implementation ("com.google.mlkit:text-recognition:16.0.0")
    implementation ("com.google.mlkit:text-recognition-devanagari:16.0.0")

    //object detection mlkit
    implementation ("com.google.mlkit:object-detection:17.0.1")

    //image detection mlkit
    implementation ("com.google.mlkit:image-labeling:17.0.8")

    //face mess detection mlkit
    implementation ("com.google.mlkit:face-mesh-detection:16.0.0-beta1")

    //face detection mlkit
    implementation ("com.google.mlkit:face-detection:16.1.6")

    //barcode scanning mlkit
    implementation ("com.google.mlkit:barcode-scanning:17.2.0")

    implementation ("com.google.accompanist:accompanist-navigation-animation:0.23.0")
    implementation ("com.google.accompanist:accompanist-permissions:0.19.0")

    implementation ("io.coil-kt:coil-compose:1.4.0")
}