package com.snssqskotlinapi.model.requestVO

import com.fasterxml.jackson.annotation.JsonProperty
import com.snssqskotlinapi.model.enums.OrderType

data class OrderRequestVO(

    @JsonProperty("owner")
    val owner: String,

    @JsonProperty("orderType")
    val orderType: OrderType

)
