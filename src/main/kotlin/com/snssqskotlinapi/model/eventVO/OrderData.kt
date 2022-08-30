package com.snssqskotlinapi.model.eventVO

import com.fasterxml.jackson.annotation.JsonProperty
import com.snssqskotlinapi.model.enums.OrderType
import java.util.*

data class OrderData(

    @JsonProperty("orderId")
    val orderId: UUID = UUID.randomUUID(),

    @JsonProperty("owner")
    val owner: String,

    @JsonProperty("orderType")
    val orderType: OrderType

)
