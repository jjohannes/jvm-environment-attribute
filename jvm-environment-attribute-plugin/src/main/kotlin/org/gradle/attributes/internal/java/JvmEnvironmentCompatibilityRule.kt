package org.gradle.attributes.internal.java

import org.gradle.api.attributes.AttributeCompatibilityRule
import org.gradle.api.attributes.CompatibilityCheckDetails
import org.gradle.api.attributes.java.JvmEnvironment

class JvmEnvironmentCompatibilityRule : AttributeCompatibilityRule<JvmEnvironment> {
    override fun execute(details: CompatibilityCheckDetails<JvmEnvironment>) {
        details.compatible()
    }
}