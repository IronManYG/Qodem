plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.ironmanyg.qodem"
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.blood_donation_domain))
    implementation(project(Modules.blood_donation_interactors))
    implementation(project(Modules.profile_domain))
    implementation(project(Modules.profile_interactors))

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)

    implementation(Compose.activity)
    implementation(Compose.ui)
    implementation(Compose.graphics)
    implementation(Compose.lifecycle)
    implementation(Compose.toolingPreview)
    implementation(Compose.material3)

    testImplementation(Junit.junit4)
    androidTestImplementation(AndroidXTest.runner)
    androidTestImplementation(ComposeTest.uiTestJunit4)
    debugImplementation(Compose.tooling)
    debugImplementation(ComposeTest.uiTestManifest)
}