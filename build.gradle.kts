import org.gradle.api.tasks.compile.JavaCompile as CompileJava
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile as CompileKotlin

plugins {
    java
    kotlin("jvm") version "1.4.21"
    application
    idea
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("net.minecrell.licenser") version "0.4.1"
    id("com.github.ben-manes.versions") version "0.36.0"
}

fun property(name: String) = project.property(name)!!.toString()

group = property("group")
base.archivesBaseName = property("archivesBaseName")
version = property("version")

repositories {
    mavenCentral()
}

dependencies {
    fun property(name: String) = project.property(name)!!.toString()

    implementation(group = "com.beust", name = "jcommander", version = property("jCommanderVersion"))
    // testing stuff
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter", version = property("junitVersion"))

    testImplementation(kotlin("test-junit5"))
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = property("junitVersion"))
    testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = property("junitVersion"))
}

tasks {
    withType<CompileJava> {
        options.encoding = "UTF-8"
    }

    withType<CompileKotlin> {
        kotlinOptions {
            jvmTarget = "1.8"
            languageVersion = "1.4"
        }
    }

    test {
        useJUnitPlatform()
    }

    dependencyUpdates {
        gradleReleaseChannel = "current"
        outputFormatter = "html"

        rejectVersionIf {
            candidate.version.contains("[.-]alpha|[.-]beta|[.-]rc\\d|[.-]m\\d".toRegex(RegexOption.IGNORE_CASE))
        }
    }
}

application {
    @Suppress("DEPRECATION")
    mainClassName = "io.github.xf8b.nines.Bruh"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(15))
    }
}

license {
    header = rootProject.file("LICENSE_HEADER")

    ext {
        this["author"] = "xf8b <unknownperson102424@pm.me>"
        this["yearWritten"] = "2021"
        this["programName"] = "Nines"
        this["description"] = "A lot of nines."
    }

    include("**/*.kt")
}
