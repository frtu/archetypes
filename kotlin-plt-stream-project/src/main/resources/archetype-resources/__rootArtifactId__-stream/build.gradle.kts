import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    java
    application
    kotlin("jvm")
    kotlin("plugin.spring") version Versions.kotlin
    kotlin("plugin.jpa") version Versions.kotlin
    id("org.springframework.boot") version Versions.spring_boot
    id("com.gorylenko.gradle-git-properties") version "2.2.4"
}

apply(plugin = "org.jetbrains.kotlin.jvm")
apply(plugin = "org.jetbrains.kotlin.plugin.spring")
apply(plugin = "io.spring.dependency-management")

dependencies {
    // Spring Cloud
    implementation("org.springframework.cloud:spring-cloud-stream")
    implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka")
//    implementation("org.springframework.cloud:spring-cloud-stream-binder-rabbit")

    // Spring Boot
//    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("org.springdoc:springdoc-openapi-ui:${Versions.springdoc}")

    // Spring Reactive
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springdoc:springdoc-openapi-webflux-ui:${Versions.springdoc}")

//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("io.r2dbc:r2dbc-h2")
//    runtimeOnly("com.h2database:h2")
//    implementation("io.r2dbc:r2dbc-postgresql")
//    runtimeOnly("org.postgresql:postgresql")

//    runtimeOnly("org.springframework.boot:spring-boot-starter-jdbc")
//    runtimeOnly("org.flywaydb:flyway-core")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    // DevTools and Monitoring
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")

    // Platform - Coroutine
    implementation(Libs.coroutines_reactor)

    // Platform test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.integration:spring-integration-test")
    testImplementation("org.springframework.cloud:spring-cloud-stream-test-support")
    testImplementation("io.projectreactor:reactor-test")
}

the<DependencyManagementExtension>().apply {
    imports {
        mavenBom(SpringBootPlugin.BOM_COORDINATES)
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${Versions.spring_cloud}")
    }
}
springBoot {
    buildInfo()
    mainClass.set("${groupId}.ApplicationKt")
}
