package com.example.componentprocessingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Component
public class ComponentProcessingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentProcessingServiceApplication.class, args);
	}

}
