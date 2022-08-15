package com.example.componentprocessingservice.Service;

import java.time.LocalDate;
import java.util.*;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.componentprocessingservice.Entity.PaymentReturnEntity;
import com.example.componentprocessingservice.Entity.ReturnRequestEntity;
import com.example.componentprocessingservice.FeignClient.PackagingAndDelieveryFeignClient;
import com.example.componentprocessingservice.Payload.ReturnRequestPayload;
import com.example.componentprocessingservice.Payload.ReturnResponsePayload;
import com.example.componentprocessingservice.Repository.PaymentReturnRepository;
import com.example.componentprocessingservice.Repository.ReturnRequestRepository;

@Service
public class ComponentService {
	@Autowired
	private ReturnRequestRepository returnRequestRepository;
	@Autowired
	private PackagingAndDelieveryFeignClient packagingAndDelieveryFeignClient;
	@Autowired
	private PaymentReturnRepository paymentReturnRepository;
	public ReturnResponsePayload getResponsePayload(ReturnRequestPayload returnRequestPayload) {
		ReturnRequestEntity returnRequestEntity =new ReturnRequestEntity();
		ReturnResponsePayload returnResponsePayload=new ReturnResponsePayload();
		BeanUtils.copyProperties(returnRequestPayload, returnRequestEntity);
		int processingDays=2;
		int processingCharge=300;
		if(returnRequestPayload.getComponentType().equalsIgnoreCase("integral")) {
			processingDays=5;
			processingCharge=500;
		}
		LocalDate date=LocalDate.now().plusDays(processingDays);
		returnResponsePayload.setDateOfDelievery(date);
		returnResponsePayload.setProcessingCharge(processingCharge);
		returnResponsePayload.setPackageAndDelieveryCharge
		(packagingAndDelieveryFeignClient.getPackagingAndDelieveryCharge
		(returnRequestPayload.getComponentType(),returnRequestPayload.getQuantity()));
		returnResponsePayload.setRequestId(UUID.randomUUID().toString().replace("-", ""));
		
		returnRequestEntity.setRequestId(UUID.randomUUID().toString().replace("-", ""));
		returnRequestEntity.setComponentName(returnRequestPayload.getComponentName());
		returnRequestEntity.setComponentType(returnRequestPayload.getComponentType());
		returnRequestEntity.setContactNumber(returnRequestPayload.getContactNumber());
		returnRequestEntity.setDateOfDelievery(date);
		returnRequestEntity.setProcessingCharge(processingCharge);
		returnRequestEntity.setPackageAndDelieveryCharge(packagingAndDelieveryFeignClient
				.getPackagingAndDelieveryCharge(returnRequestPayload.getComponentType(),returnRequestPayload.getQuantity()));
		returnRequestEntity.setQuantity(returnRequestPayload.getQuantity());
		returnRequestEntity.setUserName(returnRequestPayload.getUsername());
		returnRequestRepository.save(returnRequestEntity);
	
		
		return returnResponsePayload;
	}
		public String makePayment(String requestId,long creditCardNumber,double creditLimit,double processingCharge) {
			PaymentReturnEntity paymentReturnEntity =new PaymentReturnEntity
					(requestId,creditCardNumber,creditLimit,processingCharge);
			
			paymentReturnRepository.save(paymentReturnEntity);
			return("Operation Successful");
		}
	

}
