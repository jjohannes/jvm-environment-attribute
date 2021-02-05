// AGP7 should do this:
configurations.whenObjectAdded {
    if (name in listOf(JavaPlugin.COMPILE_CLASSPATH_CONFIGURATION_NAME, JavaPlugin.RUNTIME_CLASSPATH_CONFIGURATION_NAME)) {
        attributes.attribute(TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE, objects.named(TargetJvmEnvironment.STANDARD_JVM))
    }
    if (name in listOf("releaseRuntimeClasspath", "debugRuntimeClasspath", "releaseCompileClasspath", "debugCompileClasspath")) {
        attributes.attribute(TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE, objects.named(TargetJvmEnvironment.ANDROID)) // by Android plugin
    }
}
