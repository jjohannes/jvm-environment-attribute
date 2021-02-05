plugins {
    id("application")
}

dependencies {
    implementation("com.google.guava:guava:HEAD-android-SNAPSHOT")
}

java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

// Selects JRE because the Java plugins requests 'org.gradle.jvm.environment = desktop' and Java version >= 8
// https://scans.gradle.com/s/ucarjmcrmr2hu/dependencies?focusedDependency=WzAsMCwzNyxbMCwwLFszN11dXQ&toggled=W1swXSxbMCwwXV0
tasks.register("runtimeClasspath") {
    doLast {
        configurations.runtimeClasspath.get().forEach { println(it.name) }
    }
}