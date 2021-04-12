plugins {
    id("com.android.application") version "7.0.0-alpha14"
    id("agp-patch")
}

android {
    compileSdkVersion(30)
}

configurations.maybeCreate("releaseRuntimeClasspath").apply {
    attributes.attribute(TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE, objects.named(TargetJvmEnvironment.STANDARD_JVM))
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