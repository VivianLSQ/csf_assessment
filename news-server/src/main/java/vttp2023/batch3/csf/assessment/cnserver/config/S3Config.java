package vttp2023.batch3.csf.assessment.cnserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class S3Config {
    
    @Value("${s3.key.access}")
    private String accessKey;

    @Value("${s3.key.secret}")
    private String secretKey;
    
    @Bean
    public AmazonS3 createS3(){
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        EndpointConfiguration config  = new EndpointConfiguration("sgp1.digitaloceanspaces.com", "sgp1");

        return AmazonS3ClientBuilder.standard()
            .withEndpointConfiguration(config)
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .build(); 
    }
    
    
}
