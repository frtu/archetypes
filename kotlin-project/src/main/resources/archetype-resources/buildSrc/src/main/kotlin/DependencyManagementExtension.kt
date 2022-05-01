object Versions {
    const val java = "${java-version}"

    // Allow to enable >1.4 syntax
    const val language = "1.4"
    const val kotlin = "${kotlin-version}"
    const val kotlinx = "${kotlinx-version}"

    const val jacoco = "0.8.8"
    const val google_format = "0.8"
    const val commons_configuration = "1.10"

    const val springframework = "5.3.5"
    const val frtu_base = "${base-pom-version}"
    const val frtu_libs = "1.1.5"
    const val frtu_logs = "1.1.4"
}

object Libs {
    // Commons
    const val commons_configuration = "commons-configuration:commons-configuration:${Versions.commons_configuration}"
    const val lib_utils = "com.github.frtu.libs:lib-utils"
    const val spring_core = "org.springframework:spring-core:${Versions.springframework}"

    //---------- LOGS -----------
    // Implementation for slf4j
    const val log_impl = "ch.qos.logback:logback-classic"
    const val logger_core = "com.github.frtu.logs:logger-core"

    //---------- LIBS BOM -----------
    const val bom_kotlin_base = "com.github.frtu.archetype:kotlin-base-pom:${Versions.frtu_base}"
    const val bom_kotlin_libs = "com.github.frtu.libs:lib-kotlin-bom:${Versions.frtu_libs}"
    const val bom_logger = "com.github.frtu.logs:logger-bom:${Versions.frtu_logs}"

    //---------- TESTS -----------
    const val junit = "org.junit.jupiter:junit-jupiter"
    // Mock lib mockk or mockito
    const val mock = "io.mockk:mockk"
    const val assertions = "org.assertj:assertj-core"
}
