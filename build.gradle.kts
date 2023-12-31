import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    application
}
group = "me.asutp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {

    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

    testImplementation(kotlin("test-junit"))
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
application {
    mainClassName = "MainKt"
}