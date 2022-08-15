package com.example.componentprocessingservice.Payload;

import java.time.LocalDate;
import java.util.*;

import lombok.Data;

@Data
public class ReturnResponsePayload {
	private String requestId;
	private double processingCharge;
	private double packageAndDelieveryCharge;
	private LocalDate dateOfDelievery;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
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
	public void setDateOfDelievery(LocalDate date) {
		this.dateOfDelievery = date;
	}

}
