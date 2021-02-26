// AGP7 should do this:
configurations.whenObjectAdded {
    if (name in listOf("releaseRuntimeClasspath", "debugRuntimeClasspath", "releaseCompileClasspath", "debugCompileClasspath")) {
        attributes.attribute(TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE, objects.named(TargetJvmEnvironment.ANDROID)) // by Android plugin
    }
}
