package com.api_gateway_springBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewaySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewaySpringBootApplication.class, args);
	}

}
