package com.example.componentprocessingservice.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="authentication",url="localhost:8200")
public interface AuthenticationFeignClient {
	
	@GetMapping("/validate")
	boolean validateAndReturnUser(@RequestHeader("Authorization") String token);

}
