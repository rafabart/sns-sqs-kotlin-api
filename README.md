Running the application   
Run the LocalStack container. docker-compose up   

Create resources on the LocalStack server. We need one SNS topic and two SQS queues for this application.

To create the topic:   
aws --endpoint-url=http://localhost:4566 sns create-topic --name order-topic   

To create the queues:   
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name order-queue   

To subscribe the queues to the topic:   
aws --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:eu-central-1:000000000000:order-topic --protocol sqs --notification-endpoint arn:aws:sqs:eu-central-1:000000000000:order-queue   

To verify you can list queues and subscriptions:   
aws --endpoint-url=http://localhost:4566 sqs list-queues   
aws --endpoint-url=http://localhost:4566 sns list-subscriptions