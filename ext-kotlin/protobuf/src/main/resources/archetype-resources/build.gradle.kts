import com.google.protobuf.gradle.*

plugins {
    `java-library`
    kotlin("jvm")
    id("com.google.protobuf") version Versions.plugin_protobuf
}

group = "${groupId}"

dependencies {
    implementation("com.google.protobuf:protobuf-java:${Versions.protobuf}")
    implementation("com.google.protobuf:protobuf-java-util:${Versions.protobuf}")
    implementation("com.google.protobuf:protobuf-kotlin:${Versions.protobuf}")
    implementation("io.grpc:grpc-protobuf:${Versions.grpc}")
    implementation("io.grpc:grpc-kotlin-stub:${Versions.grpc_kotlin}")
    implementation("io.grpc:grpc-stub:${Versions.grpc}")
    implementation("io.grpc:grpc-netty:${Versions.grpc}")

    // Serialization
    implementation(Libs.jackson_databind)
    implementation(Libs.jackson_module_kotlin)

    // Platform - Coroutine
    implementation(Libs.coroutines_reactor)

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
    implementation(platform(Libs.bom_jackson))
//    implementation(platform(Libs.bom_kotlin_base))
    implementation(platform(Libs.bom_kotlin_libs))
    implementation(platform(Libs.bom_logger))
    implementation(platform(kotlin("bom")))
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
}

sourceSets {
    create("proto") {
        proto {
            srcDir("src/main/proto")
        }
    }
}

protobuf {
    protoc { artifact = "com.google.protobuf:protoc:${Versions.protobuf}" }
    plugins {
        id("grpc") { artifact = "io.grpc:protoc-gen-grpc-java:${Versions.grpc}" }
        id("grpckt") { artifact = "io.grpc:protoc-gen-grpc-kotlin:${Versions.plugin_grpc_kotlin}" }
    }
    // generatedFilesBaseDir = "$projectDir/src/main/kotlin/com.kotlingrpc.demoGrpc/generated"
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
            it.builtins {
                id("kotlin")
            }
        }
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}