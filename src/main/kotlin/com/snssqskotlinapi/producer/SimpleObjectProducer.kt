package com.snssqskotlinapi.producer

import com.snssqskotlinapi.config.AWSConfigConstants
import com.snssqskotlinapi.model.eventVO.OrderEventVO
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class SimpleObjectProducer(

    private val awsConfigConstants: AWSConfigConstants,
    private val notificationMessagingTemplate: NotificationMessagingTemplate

) {

    val logger = LoggerFactory.getLogger(this.javaClass)


    fun publish(orderEventVO: OrderEventVO) =
        notificationMessagingTemplate
            .convertAndSend(awsConfigConstants.orderTopic, orderEventVO)
            .also { logger.info("[${logger}] - [publish] - Sending order event=${orderEventVO} for topic") }
}