package com.snssqskotlinapi.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.sns.AmazonSNS
import com.amazonaws.services.sns.AmazonSNSClientBuilder
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class SnsConfig(

    private val awsConfigConstants: AWSConfigConstants

) {


    @Bean
    fun notificationMessagingTemplate(amazonSNS: AmazonSNS): NotificationMessagingTemplate =
        NotificationMessagingTemplate(amazonSNS)


    @Bean
    @Primary
    fun amazonSNS(endPointConfiguration: AwsClientBuilder.EndpointConfiguration): AmazonSNS {

        val credential = BasicAWSCredentials(awsConfigConstants.accessKey, awsConfigConstants.secretKey)

        return AmazonSNSClientBuilder
            .standard()
            .withEndpointConfiguration(endPointConfiguration)
            .withCredentials(AWSStaticCredentialsProvider(credential))
            .build()
    }


}