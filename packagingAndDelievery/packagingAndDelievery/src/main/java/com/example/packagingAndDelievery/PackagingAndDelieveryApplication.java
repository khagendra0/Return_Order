package com.example.packagingAndDelievery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PackagingAndDelieveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackagingAndDelieveryApplication.class, args);
	}

}
