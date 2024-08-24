plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("plugin.serialization") version "2.0.0"
}

android {
    namespace = "com.example.searchworkapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.searchworkapp"
        minSdk = 24
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
    implementation(libs.androidx.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    /**
     * Voyager
     */
    implementation(libs.voyager.navigator)
    implementation(libs.voyager.bottomSheetNavigator)
    implementation(libs.voyager.tabNavigator)
    implementation(libs.voyager.screenModel)

    /**
     * ImageLoader
     */
    implementation(libs.composeImageLoader)

    /**
     * Koin
     */
    implementation(libs.koin.core)
    implementation(libs.koin.android)

    /**
     * Serialization
     */
    implementation(libs.kotlinx.serialization.json)


    implementation(projects.core)
    implementation(projects.uikit)
    implementation(projects.models.domain)
    implementation(projects.models.data)
    implementation(projects.models.mappers)
    implementation(projects.features.main.ui)
    implementation(projects.features.auth.ui)
    implementation(projects.features.auth.domain)
    implementation(projects.features.auth.data)
    implementation(projects.features.main.domain)
    implementation(projects.features.main.data)
    implementation(projects.features.detail.ui)
    implementation(projects.features.detail.data)
    implementation(projects.features.search.ui)
    implementation(projects.features.favourite.domain)
    implementation(projects.features.favourite.data)
    implementation(projects.features.favourite.ui)
    implementation(projects.features.splash.ui)
    implementation(projects.features.detail.domain)
    implementation(projects.source)
    implementation(projects.managers)

}