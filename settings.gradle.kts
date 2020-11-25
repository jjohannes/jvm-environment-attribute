pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
        }
    }
}

includeBuild("jvm-environment-attribute-plugin")

dependencyResolutionManagement {
    repositories {
        maven { url = uri("local-repo") }
        mavenCentral()
        google()
    }
}


rootProject.name = "jvm-environment-attribute"
include("java-app")
include("java-app-java-7")
include("android-app")
include("android-app-force-JRE")
include("android-app-force-JRE-only-guava")
