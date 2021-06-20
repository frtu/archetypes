package ${groupId}

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink

@SpringBootApplication
@EnableBinding(Sink::class)
class Application {
    @StreamListener(Sink.INPUT)
    fun handle(message: String) {
        println("Received: $message")
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}