plugins {
    base
    `version-catalog`
    `maven-publish`
}

description = "Catalog with common lib and plugins versions defined."
group = property("group") as String

catalog {
    versionCatalog {
        val json = version("json", property("json-version") as String)
        library("serialization-json", "org.json", "json").versionRef(json)
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["versionCatalog"])
    }
}
