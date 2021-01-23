package ${groupId};

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    try {
        SpringApplication.run(Application::class.java, *args)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}