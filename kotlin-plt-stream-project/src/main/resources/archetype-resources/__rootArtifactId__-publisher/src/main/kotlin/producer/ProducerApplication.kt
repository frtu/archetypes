package ${groupId}.producer

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaTemplate

/**
 * Based on :
 * @see <a href="https://docs.spring.io/spring-kafka/reference/html/#introduction">Spring Kafka</a>
 * @author Frédéric TU
 */
@SpringBootApplication
class ProducerApplication {
    @Bean
    fun runner(producerSink: ProducerSink): ApplicationRunner = ApplicationRunner { args: ApplicationArguments? ->
        producerSink.send("${domain}-message")
    }
}

fun main(args: Array<String>) {
    System.getProperties()["server.port"] = 8083
    runApplication<ProducerApplication>(*args)
}