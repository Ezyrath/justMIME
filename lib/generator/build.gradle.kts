plugins {
    kotlin("jvm")
    application
}

group = "ezy.justmime.lib.generator"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

application {
    mainClass.set("MainKt")
}
