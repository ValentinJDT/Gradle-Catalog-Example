plugins {
    `kotlin-dsl`
    `maven-publish`
}

description = "Gradle plugins for build conventions enforcement in projects"
group = property("group") as String

repositories {
    gradlePluginPortal()
}

gradlePlugin {
    plugins {
        create("repositories") {
            id = "$group.plugins"
            implementationClass = "fr.valentinjdt.GradleRepositoriesPlugin"
        }
    }
}