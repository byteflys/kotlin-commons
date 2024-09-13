plugins {
    id("org.jetbrains.kotlin.jvm")
    id("signing")
    id("maven-publish")
    id("com.vanniktech.maven.publish")
}

dependencies {

    // Coroutine
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")

    // GSON
    api("com.google.code.gson:gson:2.11.0")

    // RxJava3
    api("io.reactivex.rxjava3:rxjava:3.1.9")
    api("io.reactivex.rxjava3:rxandroid:3.0.2")
    api("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")

    // OkHttp3
    api("com.squareup.okhttp3:okhttp:4.12.0")
    api("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // Retrofit2
    api("com.squareup.retrofit2:retrofit:2.11.0")
    api("com.squareup.retrofit2:converter-gson:2.11.0")
    api("com.squareup.retrofit2:adapter-rxjava2:2.11.0")
}

signing {
    useGpgCmd()
}

mavenPublishing {
    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()
}

// gradle publishMavenPublicationToMavenLocal
// gradle publishMavenPublicationToMavenCentralRepository