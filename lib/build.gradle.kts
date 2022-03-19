plugins {
    kotlin("multiplatform") version "1.6.10"
    id("com.google.devtools.ksp") version  "1.6.10-1.0.4"
    idea
}

group = "ezy.justmime.lib"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useTestNG()
        }
    }
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}

dependencies {
    add("kspMetadata", project(":processor"))
    add("kspJvm", project(":processor"))
    add("kspJvmTest", project(":processor"))
    add("kspJs", project(":processor"))
    add("kspJsTest", project(":processor"))
    add("kspNative", project(":processor"))
    add("kspNativeTest", project(":processor"))
}

task("testLibFast") {
    group = "app"

    dependsOn("metadataMainClasses")
    dependsOn("jvmTestClasses")
}

idea {
    module {
        sourceDirs = sourceDirs + file("build/generated/ksp/metadata/commonMain/kotlin")
        generatedSourceDirs = generatedSourceDirs + file("build/generated/ksp/metadata/commonMain/kotlin")
    }
}
