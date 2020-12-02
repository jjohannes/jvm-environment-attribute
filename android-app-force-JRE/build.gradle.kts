import org.gradle.api.attributes.java.JvmEnvironment

plugins {
    id("org.gradle.jvm-environment-attribute-support")
    id("com.android.application") version "4.1.1"
}

android {
    compileSdkVersion(30)
}

configurations.maybeCreate("releaseRuntimeClasspath").apply {
    attributes.attribute(JvmEnvironment.JVM_ENVIRONMENT_ATTRIBUTE, objects.named(JvmEnvironment.STANDARD_JVM))
}

dependencies {
    implementation("com.google.guava:guava:HEAD-jre-SNAPSHOT")
}


// Selects JRE because the User changed to 'org.gradle.jvm.environment = desktop' for 'releaseRuntimeClasspath'
// https://scans.gradle.com/s/vepjrmkppntmw/dependencies?focusedDependency=WzAsMCwzNyxbMCwwLFszN11dXQ&toggled=W1swXSxbMCwwXSxbMCwwLFszN11dXQ
tasks.register("runtimeClasspath") {
    doLast {
        configurations["releaseRuntimeClasspath"].forEach { println(it.name) }
    }
}