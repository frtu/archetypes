object Versions {
    const val java = "${java-version}"

    // Allow to enable >1.4 syntax
    const val language = "1.4"
    const val kotlin = "${kotlin-version}"
    const val kotlinx = "${kotlinx-version}"

    const val jackson = "2.13.2.1" // 2022-03-30
    const val springframework = "5.3.5"
    const val frtu_base = "${base-pom-version}"
    const val frtu_libs = "${frtu-libs-version}"
    const val frtu_logs = "${frtu-logger-version}"

    const val awaitility = "4.2.0" // 2022-03-04
    const val kotest = "5.4.2" // 2022-08-10

    const val plugin_jacoco = "0.8.8" // 2022-04-05
    const val plugin_google_format = "0.9" // 2020-06-09
    const val plugin_protobuf = "0.8.18"
    const val plugin_grpc_kotlin = "0.1.5"

    const val protobuf = "3.21.1" // 2022-05-28
    const val grpc = "1.46.0" // 2022-04-26
    const val grpc_kotlin = "1.3.0" // 2022-05-28
    const val grpc_spring_boot_starter = "2.13.1.RELEASE"
}

object Libs {
    //---------- Protobuf -----------
    const val lib_serdes_protobuf = "com.github.frtu.libs:lib-serdes-protobuf:${Versions.frtu_libs}"

    //---------- Commons -----------
    const val jackson_databind = "com.fasterxml.jackson.core:jackson-databind"
    const val jackson_module_kotlin = "com.fasterxml.jackson.module:jackson-module-kotlin"
    const val jackson_yaml = "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml"
    const val lib_utils = "com.github.frtu.libs:lib-utils"
    const val spring_core = "org.springframework:spring-core:${Versions.springframework}"

    //---------- COROUTINE -----------
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinx}"
    const val coroutines_reactive = "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${Versions.kotlinx}"
    const val coroutines_reactor = "org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${Versions.kotlinx}"

    //---------- LOGS -----------
    // Implementation for slf4j
    const val log_impl = "ch.qos.logback:logback-classic"
    const val logger_core = "com.github.frtu.logs:logger-core"

    //---------- LIBS BOM -----------
    const val bom_jackson = "com.fasterxml.jackson:jackson-bom:${Versions.jackson}"
    const val bom_kotlin_base = "com.github.frtu.archetype:kotlin-base-pom:${Versions.frtu_base}"
    const val bom_kotlin_libs = "com.github.frtu.libs:lib-kotlin-bom:${Versions.frtu_libs}"
    const val bom_logger = "com.github.frtu.logs:logger-bom:${Versions.frtu_logs}"

    //---------- TESTS -----------
    const val bom_kotest = "io.kotest:kotest-bom:${Versions.kotest}"

    const val kotest = "io.kotest:kotest-assertions-core"
    const val kotest_json = "io.kotest:kotest-assertions-json"
    const val kotest_property = "io.kotest:kotest-property"

    const val junit = "org.junit.jupiter:junit-jupiter"
    const val awaitility = "org.awaitility:awaitility-kotlin:${Versions.awaitility}"

    // Mock lib mockk or mockito
    const val mock = "io.mockk:mockk"
    const val assertions = "org.assertj:assertj-core"
}
