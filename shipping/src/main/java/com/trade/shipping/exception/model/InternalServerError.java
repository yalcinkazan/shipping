package com.trade.shipping.exception.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Internal Server Error Response")
public class InternalServerError {
	
	@ApiModelProperty(notes = "Date When Error Occured")
	private Date errorTime;
	
	@ApiModelProperty(notes = "Error Code")
	private Integer errorCode;
	
	@ApiModelProperty(notes = "Exception Cause")
	private String cause;
	
    public InternalServerError(Date errorTime, Integer errorCode, String cause) {
    	this.errorTime = errorTime;
    	this.errorCode = errorCode;
    	this.cause = cause;
    }

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Date getErrorTime() {
		return errorTime;
	}

	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
}
