package ${groupId}.proto

import ${groupId}.metadata.sla.DataSLA
import ${groupId}.metadata.sla.Sla
import com.github.frtu.kotlin.protobuf.BaseMessageMetadataHelper
import com.google.protobuf.Descriptors
import java.util.*

class SlaMetadataHelper : BaseMessageMetadataHelper<DataSLA>(Sla.dataSla) {
    fun hasSLA(messageDescriptor: Descriptors.Descriptor): Boolean {
        return super.hasExtension(messageDescriptor)
    }

    fun getSLA(messageDescriptor: Descriptors.Descriptor): Optional<DataSLA> {
        return super.getExtension(messageDescriptor)
    }
}