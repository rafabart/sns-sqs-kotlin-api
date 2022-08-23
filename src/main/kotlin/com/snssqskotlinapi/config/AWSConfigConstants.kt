package com.snssqskotlinapi.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration

@ConstructorBinding
//@ConfigurationProperties("cloud.aws")
@Configuration
class AWSConfigConstants(

    @Value("\${cloud.aws.credentials.access-key}")
    val accessKey: String,

    @Value("\${cloud.aws.credentials.secret-key}")
    val secretKey: String,

    @Value("\${cloud.aws.endpoint}")
    val endPoint: String,

    @Value("\${cloud.aws.region.static}")
    val region: String,

    @Value("\${cloud.aws.sns.order-topic.arn}")
    val orderTopic: String,

    @Value("\${cloud.aws.sqs.order-queue.url}")
    val orderQueue: String,

    )
