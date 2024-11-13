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
        addDependency("serialization-json", "org.json", "json")
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
 * Version definition in gradle.properties : key-version = <version>
 *
 * @param key to use when you need to import dependency in a project
 * @param group of the dependency
 * @param artifactId of the dependency
 */
private fun VersionCatalogBuilder.addDependency(key: String, group: String, artifactId: String) {
    val versionKey = "$key-version"
    if(!hasProperty(versionKey))
        throw MissingResourceException("Version missing of \"${group}:${artifactId}\". Please add \"$versionKey = <version>\" in gradle.properties.")

    val versionRef = version(key, property(versionKey) as String)
    library(key, group, artifactId).versionRef(versionRef)
}