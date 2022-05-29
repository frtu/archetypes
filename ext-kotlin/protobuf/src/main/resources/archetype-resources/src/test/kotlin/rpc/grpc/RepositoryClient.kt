package ${groupId}.rpc.grpc

import ${groupId}.${DatamodelClassName}ServiceGrpcKt
import ${groupId}.${DatamodelClassName}HistoryItem
import ${groupId}.${DatamodelClassName}
import com.github.frtu.kotlin.protobuf.utils.toTimestamp
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.time.Instant
import java.util.*
import java.util.concurrent.TimeUnit

suspend fun main() {
    val port = 9090
    val channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build()

    val stub: ${DatamodelClassName}ServiceGrpcKt.${DatamodelClassName}ServiceCoroutineStub =
        ${DatamodelClassName}ServiceGrpcKt.${DatamodelClassName}ServiceCoroutineStub(channel)

    // Query ONE
//    stub.queryOne(byId { this.id = "47601b76-9abd-4c81-ac45-f11bbff5c73b" }).apply {
//        println("Received: $this")
//    }

    // Query MANY
//    stub.queryMany(by { name = "test" }).collect {
//        println(it)
//        Thread.sleep(1000)
//    }

    // Insert MANY
    val insertFlow: Flow<${DatamodelClassName}HistoryItem> = flow {
        for (i in 1..5) {
            delay(2000)
            emit(${DatamodelClassName}HistoryItem.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setCreationTime(Instant.now().toTimestamp())
                .setUpdateTime(Instant.now().toTimestamp())
                .setData(
                    ${DatamodelClassName}.newBuilder()
                    .setId(1234)
                    .setName("fred")
                    .build()
                )
                .build()
            )
        }
    }
    stub.insert(insertFlow)
        .collect {
            println(it)
//            Thread.sleep(1000)
        }

    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
}
