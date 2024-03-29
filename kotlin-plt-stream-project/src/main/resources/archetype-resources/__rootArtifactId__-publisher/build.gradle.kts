//import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
//import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    java
    kotlin("jvm")
    application

//    kotlin("plugin.spring") version Versions.kotlin
//    id("org.springframework.boot") version Versions.spring_boot
}
//apply(plugin = "io.spring.dependency-management")

//the<DependencyManagementExtension>().apply {
//    imports {
//        mavenBom(SpringBootPlugin.BOM_COORDINATES)
//    }
//}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.kafka:spring-kafka")

    // Platform test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
}

application {
    // Define the main class for the application.
    mainClass.set("${groupId}.producer.ProducerApplicationKt")
}