import org.gradle.kotlin.dsl.invoke

plugins {
    kotlin("jvm") version "2.0.20"
}

group = "fr.valentinjdt"
version = "1.0-SNAPSHOT"

dependencies {
    println("Json dependency version : " + libs.serialization.json.get().version)
    implementation(libs.serialization.json)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}