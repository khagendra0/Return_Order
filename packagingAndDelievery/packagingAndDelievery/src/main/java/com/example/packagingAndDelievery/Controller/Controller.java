package com.example.packagingAndDelievery.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.example.packagingAndDelievery.Exception.ComponentTypeNotFoundException;

import com.example.packagingAndDelievery.Service.PackagingAndDelieveryService;


@RestController
@CrossOrigin("*")
public class Controller {
	
	
	@Autowired
	private PackagingAndDelieveryService packagingAndDelieveryService;
	@GetMapping("/packagingAndDelivery/getCharge/{componentType}/{count}")
	public double getPackagingAndDelieveryCharge(@PathVariable String componentType,@PathVariable int count) throws ComponentTypeNotFoundException  {
		
		return packagingAndDelieveryService.getAmount(componentType, count);
	}
		
	

}
