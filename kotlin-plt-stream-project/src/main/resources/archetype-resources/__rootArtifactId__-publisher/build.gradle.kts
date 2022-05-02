plugins {
    java
    kotlin("jvm")
    application
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.kafka:spring-kafka")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
}

application {
    // Define the main class for the application.
    mainClass.set("${groupId}.producer.ProducerApplicationKt")
}