package springboot.dynamo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoBDConfig {
	
	private String servicio = "dynamodb.us-east-1.amazonaws.com";
	private String region = "us-east-1";
	private String accessKey="AKIAXZPLTXHFVSQDZPHY";
	private String secretKey="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";
	
	@Bean
	public DynamoDBMapper mapper() {
		return new DynamoDBMapper(amazonDynamoDBConfig());
	}
	private AmazonDynamoDB amazonDynamoDBConfig() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(servicio, region)
						)
				.withCredentials(
						new AWSStaticCredentialsProvider(
								new BasicAWSCredentials(accessKey,secretKey)
								)
						)
				.build();
	}
	
}