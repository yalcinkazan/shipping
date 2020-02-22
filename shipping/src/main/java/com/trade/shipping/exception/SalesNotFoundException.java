package com.trade.shipping.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Sales Not Found")
public class SalesNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private Date errorTime;
	private Integer errorCode;
	private String errorMessage;
	private Long saleId;
	
	public SalesNotFoundException() {
		super(); 
	}
	
	public SalesNotFoundException(Date errorTime, String errorMessage, Long saleId) {
		super(); 
		this.errorTime = errorTime;
		this.errorCode = HttpStatus.NOT_FOUND.value();
		this.errorMessage = errorMessage;
		this.saleId = saleId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Date getErrorTime() {
		return errorTime;
	}

	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

}



