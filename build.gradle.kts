import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.bundling.Jar
import java.io.File

plugins {
    kotlin("jvm") version "1.9.10"
}

group = property("group")!!
version = property("version")!!

java.toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

val exposed = property("exposed_version")

dependencies {
    implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")
    implementation("junit:junit:4.12")
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    implementation("org.hibernate:hibernate-core:5.1.0.Final")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    }

    processResources {
        filesMatching("plugin.yml") {
            expand(project.properties)
        }
    }

    val jarTask = create<Jar>("paperJar") {
        archiveBaseName.set("meinPlugin") // Setze hier einen gültigen Namen für deine JAR-Datei
        archiveClassifier.set("")
        archiveVersion.set("")

        from(sourceSets["main"].output)

        // Include runtime dependencies
        from(configurations.runtimeClasspath.get().filter { it.exists() }.map { zipTree(it) })

        // Duplikate inkludieren
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }

    jarTask.doLast {
        // Kopieren der JAR-Datei in das gewünschte Verzeichnis
        val destinationDir = File("C:\\intelij\\arazune\\build\\libs")
        file("$buildDir/libs/meinPlugin.jar").copyTo(destinationDir, true)
    }
}
