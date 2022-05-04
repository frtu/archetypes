package ${groupId}.consumer

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfiguration {
    @Value("\${application.topic.domain-source}")
    lateinit var inputSource: String

    @Bean
    fun topic(): NewTopic {
        return TopicBuilder.name(inputSource)
            .partitions(10)
            .replicas(1)
            .build()
    }
}