import org.gradle.api.attributes.java.JvmEnvironment
import org.gradle.attributes.internal.java.JvmEnvironmentCompatibilityRule
import org.gradle.attributes.internal.java.JvmEnvironmentDesktopDisambiguationRule
import org.gradle.attributes.internal.java.JvmEnvironmentAndroidDisambiguationRule

configurations.whenObjectAdded {
    if (name in listOf(JavaPlugin.COMPILE_CLASSPATH_CONFIGURATION_NAME, JavaPlugin.RUNTIME_CLASSPATH_CONFIGURATION_NAME)) {
        attributes.attribute(JvmEnvironment.JVM_ENVIRONMENT_ATTRIBUTE, objects.named(JvmEnvironment.DESKTOP))
    }
    if (name in listOf("releaseRuntimeClasspath", "debugRuntimeClasspath", "releaseCompileClasspath", "debugCompileClasspath")) {
        attributes.attribute(JvmEnvironment.JVM_ENVIRONMENT_ATTRIBUTE, objects.named(JvmEnvironment.ANDROID)) // by Android plugin
    }
}

dependencies.attributesSchema.attribute(JvmEnvironment.JVM_ENVIRONMENT_ATTRIBUTE) {
    compatibilityRules.add(JvmEnvironmentCompatibilityRule::class.java)
    disambiguationRules.add(JvmEnvironmentDesktopDisambiguationRule::class.java)
    disambiguationRules.add(JvmEnvironmentAndroidDisambiguationRule::class.java) // by Android plugin
}