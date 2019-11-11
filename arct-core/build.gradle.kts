import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")

    id("com.github.johnrengelman.shadow") version "5.2.0"
    id("org.jlleitschuh.gradle.ktlint")
}

group = "io.arct"
version = "1.0.0"

repositories {
    mavenCentral()

    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    api(kotlin("stdlib-jdk8"))
    api(kotlin("reflect"))

    api(project(":"))
    implementation("org.spigotmc:spigot-api:1.14.4-R0.1-SNAPSHOT")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Wrapper> {
    gradleVersion = "5.6.3"
}

tasks.shadowJar {
    archiveClassifier.set("")
}

tasks.build {
    dependsOn("shadowJar")
}
