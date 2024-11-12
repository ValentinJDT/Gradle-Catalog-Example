package fr.valentinjdt

import groovy.lang.MissingPropertyException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.initialization.Settings
import org.gradle.api.plugins.PluginAware
import org.gradle.kotlin.dsl.extra

class GradleRepositoriesPlugin:  Plugin<PluginAware> {
    override fun apply(target: PluginAware): Unit = with(target) {
        when (this) {
            is Project -> {
                repositories.apply {
                    mavenLocal()
                    mavenCentral()
                }
            }
            is Settings -> {
                val productVersion = extra.properties["plugin-version"] as? String ?: throw MissingPropertyException("Product version not defined.")
                dependencyResolutionManagement.repositories.mavenLocal()
                dependencyResolutionManagement.versionCatalogs.create("libs") {
                    from("fr.valentinjdt:catalog:${productVersion}")
                }
            }
        }
    }
}
