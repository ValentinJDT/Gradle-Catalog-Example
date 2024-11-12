plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            from("fr.valentinjdt:catalog:${providers.gradleProperty("catalog-version").get()}")
        }
    }
}

rootProject.name = "main-project"