package ${groupId}

import com.github.frtu.logs.config.LogConfigAll
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(LogConfigAll::class)
@EnableConfigurationProperties(AppProperties::class)
@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}