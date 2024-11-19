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
            id = "$group.plugin"
            implementationClass = "${group}.plugin.GradleRepositoriesPlugin"
        }
    }
}

open class GenerateClassTask : DefaultTask() {

    @TaskAction
    fun generate() {
        val group = project.property("group") as String

        val outputDir = project.layout.buildDirectory.asFile.get().resolve("generated/sources/kotlin/main")
        val outputFile = File(outputDir, "GeneratedProperties.kt")

        outputDir.mkdirs()
        outputFile.writeText("package $group.plugin\n\n")
        outputFile.addConstant("version", project.version.toString(), "Version of the plugin.")
        outputFile.addConstant("group", group, "Group of the plugin.")
    }

    inline fun <reified T: Comparable<*>> File.addConstant(name: String, value: T, description: String? = null) {
        if(description != null && description.isNotBlank()) {
            appendText("/** $description */\n")
        }

        if(value is Number) {
            appendText("const val ${name.uppercase()} = $value\n\n")
        } else {
            appendText("const val ${name.uppercase()} = \"$value\"\n\n")
        }
    }

}

tasks.register<GenerateClassTask>("generateClass")

tasks.named("compileKotlin") {
    dependsOn("generateClass")
}

sourceSets {
    main {
        java {
            srcDir("build/generated/sources/kotlin/main")
        }
    }
}