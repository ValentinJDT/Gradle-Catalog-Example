plugins {
    base
    `version-catalog`
    `maven-publish`
}

group = "fr.valentinjdt"
version = property("version") as String

catalog {
    versionCatalog {
        val json = version("json", property("json-version") as String)
        library("serialization-json", "org.json", "json").versionRef(json)

        repositories {
            mavenCentral()
        }
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["versionCatalog"])
    }
}
