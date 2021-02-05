plugins {
    id("com.android.application") version "4.1.1"
    id("agp-patch")
}

android {
    compileSdkVersion(30)
}

dependencies {
    implementation("com.google.guava:guava:HEAD-jre-SNAPSHOT")
}


// Selects ANDROID because the Android plugin requests 'org.gradle.jvm.environment = android'
// https://scans.gradle.com/s/tohym3szvz5ai/dependencies?focusedDependency=WzAsMCwzNyxbMCwwLFszN11dXQ&toggled=W1swXSxbMCwwXSxbMCwwLFszN11dXQ
tasks.register("runtimeClasspath") {
    doLast {
        configurations["releaseRuntimeClasspath"].forEach { println(it.name) }
    }
}