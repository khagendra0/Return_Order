package com.example.componentprocessingservice.Payload;

import lombok.Data;

@Data
public class ReturnRequestPayload {
	private String userName;
	private long contactNumber;
	private boolean isPriorityRequest;
	private String componentType;
	private String componentName;
	private int quantity;
	public String getUsername() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public boolean isPriorityRequest() {
		return isPriorityRequest;
	}
	public void setPriorityRequest(boolean isPriorityRequest) {
		this.isPriorityRequest = isPriorityRequest;
	}
	public String getComponentType() {
		return componentType;
	}
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
