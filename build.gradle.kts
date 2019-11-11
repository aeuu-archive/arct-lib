import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"

    id("org.jlleitschuh.gradle.ktlint") version "9.0.0"
}

group = "io.arct"
version = "1.0.0"

repositories {
    mavenCentral()

    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("org.spigotmc:spigot-api:1.14.4-R0.1-SNAPSHOT")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Wrapper> {
    gradleVersion = "5.6.3"
}
