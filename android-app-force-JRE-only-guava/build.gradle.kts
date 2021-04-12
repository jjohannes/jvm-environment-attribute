plugins {
    id("com.android.application") version "7.0.0-alpha14"
    id("agp-patch")
}

android {
    compileSdkVersion(30)
}

dependencies {
    implementation("com.google.guava:guava:HEAD-jre-SNAPSHOT")
    constraints {
        implementation("com.google.guava:guava") {
            // can do it like this for transitives, could also do it directly on the dependency above
            attributes { attribute(TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE, objects.named(TargetJvmEnvironment.STANDARD_JVM)) }
        }
    }
}


// Selects JRE because the User explicitly requested 'org.gradle.jvm.environment = desktop' for the Guava dependency
// https://scans.gradle.com/s/6wpg2fdpn5rxo/dependencies?focusedDependency=WzAsMCw0NixbMCwwLFs0Nl1dXQ&toggled=W1swXSxbMCwwXV0
tasks.register("runtimeClasspath") {
    doLast {
        configurations["releaseRuntimeClasspath"].forEach { println(it.name) }
    }
}