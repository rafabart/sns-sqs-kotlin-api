package com.snssqskotlinapi.listener

import com.snssqskotlinapi.model.eventVO.OrderEventVO
import io.awspring.cloud.messaging.config.annotation.NotificationMessage
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy
import io.awspring.cloud.messaging.listener.annotation.SqsListener
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class SimpleObjectConsumer {

    val logger = LoggerFactory.getLogger(this.javaClass)


    @SqsListener(
        value = ["http://localhost:4566/000000000000/order-queue"],
        deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS
    )
    fun consume(@NotificationMessage orderEventVO: OrderEventVO) =
        logger.info("[${logger}] - [consume] - Received order event=${orderEventVO} for consumer")
}