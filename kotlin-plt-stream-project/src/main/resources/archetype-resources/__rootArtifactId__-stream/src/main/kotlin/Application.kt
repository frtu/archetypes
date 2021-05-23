package ${groupId}

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.cloud.stream.annotation.EnableBinding

@EnableConfigurationProperties(AppProperties::class)
@SpringBootApplication
//@EnableR2dbcRepositories
@EnableBinding(AppProcessor::class)
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}