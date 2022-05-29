package ${groupId}

import ${groupId}.*
import com.github.frtu.kotlin.protobuf.utils.toTimestamp
import io.grpc.Server
import io.grpc.ServerBuilder
import java.time.Instant
import java.util.*

class RepositoryServer(private val port: Int) {
    val server: Server = ServerBuilder
        .forPort(port)
        .addService(${DatamodelClassName}ServiceHandler())
        .build()

    fun start() {
        server.start()
        println("Server started, listening on $port")
        Runtime.getRuntime().addShutdownHook(
            Thread {
                println("*** shutting down gRPC server since JVM is shutting down")
                this@RepositoryServer.stop()
                println("*** server shut down")
            }
        )
    }

    private fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }

    internal class ${DatamodelClassName}ServiceHandler :
        ${DatamodelClassName}ServiceGrpcKt.${DatamodelClassName}ServiceCoroutineImplBase() {
        override suspend fun queryOne(request: ById): ${DatamodelClassName}HistoryItem =
        ${DatamodelClassName}HistoryItem.newBuilder()
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
    }
}

fun main() {
    val port = System.getenv("PORT")?.toInt() ?: 9090
    val server = RepositoryServer(port)
    server.start()
    server.blockUntilShutdown()
}
