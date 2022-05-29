package ${groupId}.proto

import ${groupId}.${DatamodelClassName}
import ${groupId}.metadata.sla.DataSLA
import com.google.protobuf.Descriptors

private val slaMetadataHelper = SlaMetadataHelper()

fun main() {
    val personDescriptor: Descriptors.Descriptor = ${DatamodelClassName}.getDescriptor()
    val dataSLA: DataSLA = slaMetadataHelper.getSLA(personDescriptor).get()
    println(dataSLA.toString())
}
