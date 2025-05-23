plugins {
    kotlin("jvm") version "1.9.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:5.8.1")
    testImplementation("io.kotest:kotest-assertions-core:5.8.1")
    testImplementation("io.kotest:kotest-framework-datatest:5.8.1")
    testImplementation("io.rest-assured:rest-assured:5.4.0")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}

tasks.test {
    useJUnitPlatform()
}