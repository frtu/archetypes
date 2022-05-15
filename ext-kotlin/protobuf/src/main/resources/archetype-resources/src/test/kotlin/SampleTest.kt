package ${groupId}

import com.google.protobuf.InvalidProtocolBufferException
import com.google.protobuf.util.JsonFormat
import org.junit.jupiter.api.Test

class SampleTest {
    @Test
    @Throws(InvalidProtocolBufferException::class)
    fun printJSON() {
        val sample: ${DatamodelClassName} = ${DatamodelClassName}.newBuilder()
            .setId(1234)
            .setName("fred")
            .build()
        val json = JsonFormat.printer()
            .preservingProtoFieldNames()
            .includingDefaultValueFields()
            .print(sample)
        println(json)
    }
}
