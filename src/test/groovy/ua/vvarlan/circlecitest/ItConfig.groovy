package ua.vvarlan.circlecitest

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.sns.AmazonSNS
import com.amazonaws.services.sns.AmazonSNSClientBuilder
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

@TestConfiguration
class ItConfig {

    @Primary
    @Bean(name = "amazonSnsMock")
    AmazonSNS amazonSns() {
        return AmazonSNSClientBuilder.standard()
                                     .withEndpointConfiguration(this.awsLocalstackEndpoint())
                                     .withCredentials(this.awsMockCredentials())
                                     .build()
    }

    private AwsClientBuilder.EndpointConfiguration awsLocalstackEndpoint() {
        return new AwsClientBuilder.EndpointConfiguration(getLocalstackHost(), getLocalstackRegion())
    }

    @Primary
    @Bean(name = "amazonSqsMock")
    AmazonSQS amazonSqs() {
        return AmazonSQSClientBuilder.standard()
                                     .withEndpointConfiguration(this.awsLocalstackEndpoint())
                                     .withCredentials(this.awsMockCredentials())
                                     .build()
    }

    private String getLocalstackRegion() {
        return System.getProperty('WB_LOCALSTACK_REGION')
    }

    private String getLocalstackHost() {
        return System.getProperty('WB_LOCALSTACK_HOST')
    }

    private AWSStaticCredentialsProvider awsMockCredentials() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials("foo", "bar"))
    }
}
