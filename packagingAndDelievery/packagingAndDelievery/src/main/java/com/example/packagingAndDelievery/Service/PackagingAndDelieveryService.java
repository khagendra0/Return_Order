package com.example.packagingAndDelievery.Service;

import org.springframework.stereotype.Service;

import com.example.packagingAndDelievery.Exception.ComponentTypeNotFoundException;

@Service
public class PackagingAndDelieveryService {
	private static final double packaging_and_delievery_accessory=150;
	private static final double packaging_and_delievery_integral=300;
	private static final double proctective_sheath=50;
	public double getAmount(String componentType,int quant) throws ComponentTypeNotFoundException {
		if(quant<=0) {
			throw new IllegalArgumentException("Quantity must be greater than zero.");
		}
		else if(componentType.equalsIgnoreCase("accessory")) {
			return (packaging_and_delievery_accessory+proctective_sheath)*quant;
		}
		else if(componentType.equalsIgnoreCase("integral")) {
			return (packaging_and_delievery_integral+proctective_sheath)*quant;
		}
		else {
			throw new ComponentTypeNotFoundException("There is no delievery with this  component type");
		}
	}
	

}
