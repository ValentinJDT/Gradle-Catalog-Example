package fr.valentinjdt

import groovy.lang.MissingPropertyException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.initialization.Settings
import org.gradle.api.plugins.PluginAware
import org.gradle.kotlin.dsl.extra

class GradleRepositoriesPlugin:  Plugin<PluginAware> {

    // Define the repositories for the project dependencies.
    private fun RepositoryHandler.defineRepositories() {
        mavenLocal()
        mavenCentral()
    }

    override fun apply(target: PluginAware): Unit = with(target) {
        when (this) {
            is Project -> {
                repositories.defineRepositories()
            }
            is Settings -> {
                val productVersion = extra.properties["plugin-version"] as? String ?: throw MissingPropertyException("Product version not defined.")
                dependencyResolutionManagement.repositories.defineRepositories()
                dependencyResolutionManagement.versionCatalogs.create("libs") {
                    from("fr.valentinjdt:catalog:${productVersion}")
                }
            }
        }
    }
}
