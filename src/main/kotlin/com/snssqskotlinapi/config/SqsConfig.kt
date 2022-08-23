package com.snssqskotlinapi.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import io.awspring.cloud.messaging.config.QueueMessageHandlerFactory
import io.awspring.cloud.messaging.support.NotificationMessageArgumentResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.messaging.converter.MessageConverter
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver

@Configuration
class SqsConfig(

    private val awsConfigConstants: AWSConfigConstants

) {


    @Bean
    fun endpointConfiguration(): EndpointConfiguration {
        return EndpointConfiguration(awsConfigConstants.endPoint, awsConfigConstants.region)
    }


    @Bean
    @Primary
    fun amazonSQSAsync(endpointConfiguration: EndpointConfiguration): AmazonSQSAsync {

        val credentials = BasicAWSCredentials(awsConfigConstants.accessKey, awsConfigConstants.secretKey)

        return AmazonSQSAsyncClientBuilder
            .standard()
            .withEndpointConfiguration(endpointConfiguration)
            .withCredentials(AWSStaticCredentialsProvider(credentials))
            .build()
    }


    @Bean
    fun queueMessageHandlerFactory(messageConverter: MessageConverter): QueueMessageHandlerFactory {

        val factory = QueueMessageHandlerFactory()

        factory.setArgumentResolvers(
            listOf<HandlerMethodArgumentResolver>(
                NotificationMessageArgumentResolver(
                    messageConverter
                )
            )
        )
        return factory
    }


    @Bean
    protected fun messageConverter(objectMapper: ObjectMapper): MessageConverter {

        val converter = MappingJackson2MessageConverter()

        converter.objectMapper = objectMapper
        converter.serializedPayloadClass = String::class.java
        converter.isStrictContentTypeMatch = false

        return converter
    }


    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
    }

}
