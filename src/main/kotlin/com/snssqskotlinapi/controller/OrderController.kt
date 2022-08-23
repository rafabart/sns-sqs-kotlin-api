package com.snssqskotlinapi.controller

import com.snssqskotlinapi.model.eventVO.OrderData
import com.snssqskotlinapi.model.eventVO.OrderEventVO
import com.snssqskotlinapi.model.requestVO.OrderRequestVO
import com.snssqskotlinapi.producer.SimpleObjectProducer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("orders")
class OrderController(

    private val producer: SimpleObjectProducer

) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(@RequestBody orderRequestVO: OrderRequestVO) {
        OrderData(owner = orderRequestVO.owner)
            .let {
                OrderEventVO(
                    orderData = it,
                    orderType = orderRequestVO.orderType
                )
            }
            .let(producer::publish)
    }
}