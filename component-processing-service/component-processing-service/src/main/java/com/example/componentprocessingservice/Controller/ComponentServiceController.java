package com.example.componentprocessingservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.componentprocessingservice.FeignClient.AuthenticationFeignClient;
import com.example.componentprocessingservice.Payload.ReturnRequestPayload;
import com.example.componentprocessingservice.Payload.ReturnResponsePayload;
import com.example.componentprocessingservice.Service.ComponentService;

@RestController
@CrossOrigin("*")
public class ComponentServiceController {
	
	@Autowired
	private AuthenticationFeignClient authenticationFeignClient;
	@Autowired
	private ComponentService componentService;
	@PostMapping("/ProcessDetails")
	public ReturnResponsePayload createReturnRequest(@RequestHeader("Authorization") String token,@RequestBody ReturnRequestPayload returnRequestPayload) {
		
		return componentService.getResponsePayload(returnRequestPayload);
	}
	@PostMapping("/CompleteProcessing/{requestId}/{creditCardNumber}/{creditLimit}/{processingCharge}")
	
	public String paymentRequest(@RequestHeader("Authorization") String token,@PathVariable String requestId,@PathVariable long creditCardNumber,@PathVariable long creditLimit
			,@PathVariable double processingCharge) {
		authenticationFeignClient.validateAndReturnUser(token.substring(7));
		return componentService.makePayment(requestId, creditCardNumber, creditLimit, processingCharge);
	}
	

}
