package org.gradle.attributes.internal.java

import org.gradle.api.attributes.AttributeDisambiguationRule
import org.gradle.api.attributes.MultipleCandidatesDetails
import org.gradle.api.attributes.java.JvmEnvironment

class JvmEnvironmentDesktopDisambiguationRule : AttributeDisambiguationRule<JvmEnvironment> {
    override fun execute(details: MultipleCandidatesDetails<JvmEnvironment>) {
        val exactMatches = details.candidateValues.filter { it == details.consumerValue }
        val desktopCandidates = details.candidateValues.filter { it.name == JvmEnvironment.STANDARD_JVM }
        if (exactMatches.size == 1) {
            details.closestMatch(exactMatches.first())
        } else if (desktopCandidates.size == 1) {
            details.closestMatch(desktopCandidates.first())
        }
    }

}