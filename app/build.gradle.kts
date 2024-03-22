plugins {
    alias(libs.plugins.androidApplication)
    kotlin("kapt") version "1.9.23"
    kotlin("android") version "1.9.23"
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.bimbodemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bimbodemo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }

    dataBinding {
       enable = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
    implementation(libs.databinding.runtime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    //retrofit
    implementation(libs.retrofit)
    implementation (libs.retrofit.converter)
    //hilt
    implementation (libs.hilt)
    kapt(libs.hilt.compiler)
    //room
    implementation(libs.room)
    kapt(libs.room.compiler)
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

    implementation("com.squareup.retrofit2:adapter-rxjava2:2.4.0")
    implementation("androidx.room:room-rxjava2:2.6.1")
    implementation("com.github.bumptech.glide:glide:4.11.0")

}