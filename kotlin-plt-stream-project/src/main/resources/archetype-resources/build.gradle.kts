import org.gradle.api.tasks.diagnostics.internal.dependencies.AsciiDependencyReportRenderer
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins {
    kotlin("jvm")
    java
    jacoco
    pmd
    `java-library`
    `maven-publish`
    id("com.github.sherter.google-java-format") version Versions.plugin_google_format

    kotlin("plugin.spring") version "${kotlin-version}" apply false
    id("org.springframework.boot") version "${spring-boot-version}" apply false
}

group = "${groupId}"

allprojects {
    apply(plugin = "java")
    apply(plugin = "jacoco")
    apply(plugin = "com.github.sherter.google-java-format")
    apply(plugin = "project-report")
    apply(plugin = "io.spring.dependency-management")

    task("allDependencies", DependencyReportTask::class) {
        evaluationDependsOnChildren()
        this.setRenderer(AsciiDependencyReportRenderer())
    }
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = Versions.java
            languageVersion = Versions.language
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
    java {
        sourceCompatibility = JavaVersion.toVersion(Versions.java)
        targetCompatibility = JavaVersion.toVersion(Versions.java)
        withSourcesJar()
    }

    jacoco {
        toolVersion = Versions.plugin_jacoco
    }
    tasks {
        test {
            useJUnitPlatform()
        }
        jacocoTestCoverageVerification {
            violationRules {
                // Configure the ratio based on your standard
                rule { limit { minimum = BigDecimal.valueOf(0.0) } }
            }
        }
        check {
            dependsOn(jacocoTestCoverageVerification)
        }
    }

    repositories {
        mavenLocal()
        mavenCentral()
    }
}

subprojects {
    dependencies {
        // Serialization
        implementation(Libs.jackson_databind)
        implementation(Libs.jackson_module_kotlin)
        implementation(Libs.jackson_datatype_jsr310)

        // Platform - Coroutine
        implementation(Libs.coroutines_reactor)

        // Platform - Observability
        implementation(Libs.opentelemetry_sdk)
        implementation(Libs.opentelemetry_trace_propagators)
        implementation(Libs.opentelemetry_semconv)
        implementation(Libs.opentelemetry_shim)
        implementation(Libs.opentelemetry_exporter)
        implementation(Libs.trace_impl)

        // Platform - Log
        implementation(Libs.logger_core)
        implementation(Libs.log_impl)
        testImplementation(Libs.lib_utils)
        testImplementation(Libs.spring_core)

        // Test
        testImplementation(Libs.junit)
        testImplementation(Libs.mock)
        testImplementation(Libs.assertions)
        testImplementation(kotlin("test"))

        // Platform - BOMs
        implementation(platform(kotlin("bom")))
        implementation(kotlin("stdlib-jdk8"))
        implementation(kotlin("reflect"))
    }

    the<DependencyManagementExtension>().apply {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
            mavenBom(Libs.bom_jackson)
//            mavenBom(Libs.bom_kotlin_base)
            mavenBom(Libs.bom_kotlin_libs)
            mavenBom(Libs.bom_logger)
            mavenBom(Libs.bom_opentelemetry)
            mavenBom(Libs.bom_opentelemetry_alpha)
            mavenBom(Libs.bom_opentelemetry_instrumentation_alpha)
        }
    }
}
