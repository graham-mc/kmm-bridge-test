pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

include("template", "breeds", "analytics", "allshared", ":testapps:android")
