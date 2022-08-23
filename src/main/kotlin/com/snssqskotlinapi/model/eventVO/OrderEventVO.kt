package com.snssqskotlinapi.model.eventVO

import com.fasterxml.jackson.annotation.JsonProperty
import com.snssqskotlinapi.model.enums.OrderType
import java.time.LocalDateTime
import java.util.UUID

data class OrderEventVO(

    @JsonProperty("eventId")
    val eventId: UUID = UUID.randomUUID(),

    @JsonProperty("occurredAt")
    val occurredAt: String = LocalDateTime.now().toString(),

    @JsonProperty("orderType")
    val orderType: OrderType,

    @JsonProperty("orderData")
    val orderData: OrderData

//    @JsonProperty("version")
//    var version: String,


)

//) : Comparable<EventVO> {


//    override fun compareTo(other: EventVO): Int {
//
//        val otherVersion = other.version.toInt()
//        val thisVersion = this.version.toInt()
//
//        return thisVersion.compareTo(otherVersion)
//    }
//
//
//    override fun toString(): String =
//        "Event{" +
//                "eventId='" + this.eventId + '\'' +
//                ", version='" + this.version + '\'' +
//                ", occurredAt='" + this.occurredAt + '\'' +
//                ", eventData=" + this.eventData +
//                '}'

//}
