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
        value = ["http://localhost:4566/000000000000/order-queue-created"],
        deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS
    )
    fun consumeCreated(@NotificationMessage orderEventVO: OrderEventVO) =
        logger.info("[${logger}] - [consumeCreated] - Received order event=${orderEventVO} for consumer")


    @SqsListener(
        value = ["http://localhost:4566/000000000000/order-queue-cancelled"],
        deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS
    )
    fun consumeCancelled(@NotificationMessage orderEventVO: OrderEventVO) =
        logger.info("[${logger}] - [consumeCancelled] - Received order event=${orderEventVO} for consumer")
}