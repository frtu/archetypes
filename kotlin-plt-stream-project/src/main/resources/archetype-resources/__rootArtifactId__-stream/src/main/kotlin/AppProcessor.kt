package ${groupId}

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel
import org.springframework.stereotype.Component

@Component
interface AppProcessor {
    @Input(INPUT)
    fun inputChannel(): SubscribableChannel

    @Output(OUTPUT)
    fun outputChannel(): MessageChannel

    companion object {
        const val INPUT = "input"
        const val OUTPUT = "output"
    }
}
