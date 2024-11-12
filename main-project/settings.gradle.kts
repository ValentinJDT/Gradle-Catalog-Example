
pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    id("fr.valentinjdt.plugins") version "1.0-SNAPSHOT"
}


rootProject.name = "main-project"