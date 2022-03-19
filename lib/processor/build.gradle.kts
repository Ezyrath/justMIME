plugins {
    kotlin("multiplatform")
}

group = "ezy.justmime.lib.processor"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation("com.google.devtools.ksp:symbol-processing-api:1.6.10-1.0.4")
            }
        }
    }
}
