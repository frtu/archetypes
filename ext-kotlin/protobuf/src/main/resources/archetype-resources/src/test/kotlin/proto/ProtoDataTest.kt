package ${groupId}.proto

import ${groupId}.${DatamodelClassName}
import ${groupId}.${DatamodelClassName}Event
import com.github.frtu.kotlin.protobuf.utils.toTimestamp
import com.google.protobuf.InvalidProtocolBufferException
import com.google.protobuf.util.JsonFormat
import org.junit.jupiter.api.Test
import java.time.Instant
import java.util.*

class ProtoDataTest {
    @Test
    @Throws(InvalidProtocolBufferException::class)
    fun printJSON() {
        // Using basic Builder syntax
        val sample = ${DatamodelClassName}Event.newBuilder()
            .setId(UUID.randomUUID().toString())
            .setEventTime(Instant.now().toTimestamp())
            .setData(
                ${DatamodelClassName}.newBuilder()
                .setId(1234)
                .setName("fred")
                .build()
            )
            .build()

        val json = JsonFormat.printer()
            .preservingProtoFieldNames()
            .includingDefaultValueFields()
            .print(sample)
        println(json)
    }
}
