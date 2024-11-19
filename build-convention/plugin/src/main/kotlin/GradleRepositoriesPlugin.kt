package fr.valentinjdt.dependencies.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.initialization.Settings
import org.gradle.api.plugins.PluginAware


// Define the repositories for the project dependencies.
private fun RepositoryHandler.defineRepositories() {
    mavenLocal()
    mavenCentral()
}

class GradleRepositoriesPlugin: Plugin<PluginAware> {

    override fun apply(target: PluginAware): Unit = with(target) {
        when (this) {
            is Project -> {
                repositories.defineRepositories()
            }
            is Settings -> {
                dependencyResolutionManagement.repositories.defineRepositories()
                dependencyResolutionManagement.versionCatalogs.create("libs") {
                    from("${GROUP}:catalog:${VERSION}")
                }
            }
        }
    }
}


