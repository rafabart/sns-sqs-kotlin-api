package com.snssqskotlinapi.model.eventVO

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class OrderData(

    @JsonProperty("orderId")
    val orderId: UUID = UUID.randomUUID(),

    @JsonProperty("owner")
    val owner: String

)
