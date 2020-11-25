plugins {
    id("org.gradle.jvm-environment-attribute-support")
    id("application")
}

dependencies {
    implementation("com.google.guava:guava:HEAD-android-SNAPSHOT")
}

java.targetCompatibility = JavaVersion.VERSION_1_7

// Selects ANDROID because Java version <8
// https://scans.gradle.com/s/folfpymiv72ey/dependencies?focusedDependency=WzAsMCwzNyxbMCwwLFszN11dXQ&toggled=W1swXSxbMCwwXV0
tasks.register("runtimeClasspath") {
    doLast {
        configurations.runtimeClasspath.get().forEach { println(it.name) }
    }
}