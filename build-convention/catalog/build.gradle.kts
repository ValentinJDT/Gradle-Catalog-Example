import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo

plugins {
    base
    `version-catalog`
    `maven-publish`
}

description = "Catalog with common lib and plugins versions defined."
group = property("group") as String

catalog {
    versionCatalog {
        // Json dependency :
        addDependency("serialization-json", "org.json:json", "20210307")
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["versionCatalog"])
    }
}

/**
 * Add a dependency into the catalog.
 *
 * @param key to use when you need to import dependency in a project
 * @param artifact define by group:artifactId
 * @param version of the dependency, not required if defined in gradle.properties
 */
private fun VersionCatalogBuilder.addDependency(key: String, artifact: String, version: String? = null) {
    val (group, artifactId) = artifact.split(":")
    val versionKey = "$key-version"

    val versionRef = if(version != null) {

        if(version.isEmpty())
            throw IllegalArgumentException("Version of \"$key\" can't be empty. Define it has null if you want to use the version defined in gradle.properties.")

        version(key, version)
    } else {
        if(!hasProperty(versionKey))
            throw MissingResourceException("Version missing of \"${group}:${artifactId}\". Please add \"$versionKey = <version>\" in gradle.properties.")

        version(key, property(versionKey) as String)
    }

    library(key, group, artifactId).versionRef(versionRef)

}