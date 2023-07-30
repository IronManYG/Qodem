object Firebase {
    // Firebase
    private const val firebaseBOMVersion = "32.2.0"
    const val firebaseBOM = "com.google.firebase:firebase-bom:$firebaseBOMVersion"
    const val fireStore = "com.google.firebase:firebase-firestore-ktx"
    // A Kotlin-first SDK for Firebase supports multiplatform projects
    private const val firebaseKmmVersion = "1.8.1"
    const val authenticationKmm = "dev.gitlive:firebase-auth:$firebaseKmmVersion"
    const val fireStoreKmm = "dev.gitlive:firebase-firestore:$firebaseKmmVersion"

    const val plugin = "com.google.gms.google-services"
}