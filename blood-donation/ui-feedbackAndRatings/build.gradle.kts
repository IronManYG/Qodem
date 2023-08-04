apply(
    from = "$rootDir/android-library-build.gradle",
)

plugins {
    id("com.android.library")
}

android {
    packaging {
        resources {
            excludes += setOf("META-INF/AL2.0", "META-INF/LGPL2.1")
        }
    }
    namespace = "com.ironmanyg.ui_feedbackandratings"
}

dependencies {
    "testImplementation"(Junit.junit4)

    "androidTestImplementation"(ComposeTest.uiTestJunit4)
    "debugImplementation"(ComposeTest.uiTestManifest)
    "androidTestImplementation"(Junit.junit4)
}