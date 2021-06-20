package ${groupId}.consumer

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.config.TopicBuilder

/**
 * Based on :
 * @see <a href="https://docs.spring.io/spring-kafka/reference/html/#introduction">Spring Kafka</a>
 * @author Frédéric TU
 */
@SpringBootApplication
class ConsumerApplication {
    companion object {
        const val inputSource: String = "domain-source"
    }
//    @Value("\${application.topic.domain-source}")
//    lateinit var inputSource: String

    @Bean
    fun topic(): NewTopic {
        return TopicBuilder.name(inputSource)
            .partitions(10)
            .replicas(1)
            .build()
    }

    @KafkaListener(id = "consumer-1", topics = [inputSource])
    fun listen(input: String?) {
        println(input)
    }
}

fun main(args: Array<String>) {
    runApplication<ConsumerApplication>(*args)
}