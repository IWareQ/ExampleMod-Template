import net.minecraftforge.gradle.user.patch.UserPatchExtension

buildscript {
    repositories {
        mavenCentral()
        maven("https://maven.minecraftforge.net/")
    }

    dependencies {
        classpath("com.anatawa12.forge:ForgeGradle:1.2-1.1.+") {
            isChanging = true
        }
    }
}

plugins {
    `java-library`
    idea
}

apply(plugin = "forge")

group = "com.example"
description = "This is a ExampleMod for Forge 1.7.10"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}

val minecraftVersion: String by project
extensions.configure(UserPatchExtension::class) {
    val forgeVersion: String by project
    setVersion("$minecraftVersion-$forgeVersion")
}

tasks.processResources {
    filesMatching("mcmod.info") {
        expand(
            "modid" to project.name.lowercase(),
            "name" to project.name,
            "description" to project.description,
            "version" to project.version,
            "mcversion" to minecraftVersion
        )
    }
}

tasks.withType<JavaCompile> {
    options.encoding = Charsets.UTF_8.name()
}

tasks.withType<Copy> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.register<Jar>("sourcesJar") {
    dependsOn(tasks.getByName("classes"))
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
}

tasks.register<Jar>("devJar") {
    archiveClassifier.set("dev")
    from(sourceSets.getByName("main").output)
}

artifacts {
    archives(tasks.getByName("sourcesJar"))
    archives(tasks.getByName("devJar"))
}

