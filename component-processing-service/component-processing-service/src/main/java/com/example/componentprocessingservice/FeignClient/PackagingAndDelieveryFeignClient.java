package com.example.componentprocessingservice.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="packaging-and-delievery-service",url="localhost:8100")
public interface PackagingAndDelieveryFeignClient {
	@GetMapping("packagingAndDelivery/getCharge/{componentType}/{count}")
	public double getPackagingAndDelieveryCharge(@PathVariable String componentType,@PathVariable int count);

}
