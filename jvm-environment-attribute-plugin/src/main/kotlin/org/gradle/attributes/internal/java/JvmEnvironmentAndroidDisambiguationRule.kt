package org.gradle.attributes.internal.java

import org.gradle.api.attributes.AttributeDisambiguationRule
import org.gradle.api.attributes.MultipleCandidatesDetails
import org.gradle.api.attributes.java.JvmEnvironment

class JvmEnvironmentAndroidDisambiguationRule : AttributeDisambiguationRule<JvmEnvironment> {
    override fun execute(details: MultipleCandidatesDetails<JvmEnvironment>) {
        val desktopCandidates = details.candidateValues.filter { it.name == JvmEnvironment.ANDROID }
        if (desktopCandidates.size == 1) {
            details.closestMatch(desktopCandidates.first())
        }
    }

}