package com.example.componentprocessingservice.Entity;
import java.time.LocalDate;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ReturnRequest")
public class ReturnRequestEntity {
	@Id

	private String requestId;
	private String userName;
	private long contactNumber;
	private String componentType;
	private String componentName;
	private int quantity;
	private double processingCharge;
	private double packageAndDelieveryCharge;
	private LocalDate dateOfDelievery;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
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
	public double getProcessingCharge() {
		return processingCharge;
	}
	public void setProcessingCharge(double processingCharge) {
		this.processingCharge = processingCharge;
	}
	public double getPackageAndDelieveryCharge() {
		return packageAndDelieveryCharge;
	}
	public void setPackageAndDelieveryCharge(double packageAndDelieveryCharge) {
		this.packageAndDelieveryCharge = packageAndDelieveryCharge;
	}
	public LocalDate getDateOfDelievery() {
		return dateOfDelievery;
	}
	public void setDateOfDelievery(LocalDate dateOfDelievery) {
		this.dateOfDelievery = dateOfDelievery;
	}


}
