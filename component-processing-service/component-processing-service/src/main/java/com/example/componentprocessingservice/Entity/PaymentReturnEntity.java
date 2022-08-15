package com.example.componentprocessingservice.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Payment")

public class PaymentReturnEntity {
	@Id
	private String requestId;
	private long creditCardNumber;
	private double creditLimit;
	private double processingCharge;
	public PaymentReturnEntity(String requestId, long creditCardNumber, double creditLimit, double processingCharge) {
		super();
		this.requestId = requestId;
		this.creditCardNumber = creditCardNumber;
		this.creditLimit = creditLimit;
		this.processingCharge = processingCharge;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public double getProcessingCharge() {
		return processingCharge;
	}
	public void setProcessingCharge(double processingCharge) {
		this.processingCharge = processingCharge;
	}

}
