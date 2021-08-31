package ua.vvarlan.circlecitest

import com.amazonaws.services.sns.AmazonSNS
import com.amazonaws.services.sqs.AmazonSQS
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.testcontainers.containers.localstack.LocalStackContainer
import org.testcontainers.utility.DockerImageName
import spock.lang.Shared

class LocalStackSpec extends BaseSpec {

    @Autowired
    AmazonSNS amazonSNS
    @Autowired
    AmazonSQS amazonSQS
    @Autowired
    ObjectMapper objectMapper
    String snsTopicArn
    String snsSubscriptionArn
    String sqsQueueUrl

    @Shared
    static LocalStackContainer localstack

    def setupSpec() {
        // starting docker localstack container
        DockerImageName localstackImage = DockerImageName.parse("localstack/localstack:0.11.3")
        localstack = new LocalStackContainer(localstackImage).withServices(LocalStackContainer.Service.SNS, LocalStackContainer.Service.SQS)
        localstack.start()
        System.setProperty('WB_LOCALSTACK_REGION', localstack.region)
        System.setProperty('WB_LOCALSTACK_HOST', "http://localhost:${localstack.firstMappedPort}")
    }

    def cleanupSpec() {
        localstack.stop()
    }

    def setup() {
        // creating sns topic
        snsTopicArn = amazonSNS.createTopic('someTopic').topicArn
        // creating sqs queue
        sqsQueueUrl = amazonSQS.createQueue('test_queue').queueUrl
        // subscribing sqs queue to sns topic
        snsSubscriptionArn = amazonSNS.subscribe(snsTopicArn, 'sqs', sqsQueueUrl).subscriptionArn
    }

    def '123'() {
        expect: ''
        1 == 1
    }

}
