package com.trade.shipping.exception.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Sales Not Found Error Response")
public class SalesNotFoundError {
	
	@ApiModelProperty(notes = "Date When Error Occured")
	private Date errorTime;
	
	@ApiModelProperty(notes = "Error Code")
	private Integer errorCode;
	
	@ApiModelProperty(notes = "Error Message")
    private String errorMessage;
	
	@ApiModelProperty(notes = "Sale Id")
    private Long saleId;

    public SalesNotFoundError(Date errorTime, Integer errorCode, String errorMessage, Long saleId) {
    	this.errorTime = errorTime;
    	this.errorCode = errorCode;
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
