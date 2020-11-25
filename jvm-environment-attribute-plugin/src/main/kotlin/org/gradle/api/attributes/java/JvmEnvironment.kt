package org.gradle.api.attributes.java

import org.gradle.api.Named
import org.gradle.api.attributes.Attribute

abstract class JvmEnvironment : Named {

    companion object {
        val JVM_ENVIRONMENT_ATTRIBUTE = Attribute.of("org.gradle.jvm.environment", JvmEnvironment::class.java)
        const val DESKTOP = "desktop"
        const val ANDROID = "android"
    }
}