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
        val mainPackage = "$group.plugin"

        val outputDir = File(project.buildDir, "generated/sources/kotlin/main")
        val outputFile = File(outputDir, "GeneratedProperties.kt")

        outputDir.mkdirs()
        outputFile.writeText(
            """
            package $mainPackage

            const val VERSION: String = "${project.version}"
            const val GROUP: String = "$group"
            """.trimIndent()
        )
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