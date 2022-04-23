import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    jacoco
    application
    kotlin("plugin.spring") version "${kotlin-version}"
    kotlin("plugin.jpa") version "${kotlin-version}"
    id("org.springframework.boot") version "${spring-boot-version}"
}
apply(plugin = "io.spring.dependency-management")

group = "${groupId}"

allprojects {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions{
            jvmTarget = "${java-version}"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

dependencies {
    // Platform - Log
    implementation("com.github.frtu.logs:logger-core")
    implementation("ch.qos.logback:logback-classic")
    testImplementation("com.github.frtu.libs:lib-utils")
    testImplementation("org.springframework:spring-core:5.3.5")
    
    // Test
    testImplementation("io.mockk:mockk")
    testImplementation("org.assertj:assertj-core")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    // Platform - BOMs
    implementation(platform("com.github.frtu.archetype:kotlin-base-pom:${base-pom-version}"))
    implementation(platform("com.github.frtu.libs:lib-kotlin-bom:1.1.5"))
    implementation(platform("com.github.frtu.logs:logger-bom:1.1.4"))
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
