package com.trade.shipping.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "saleId", "status", "createdAt" })
public class ShippingResponse {
	
	@JsonProperty("saleId")
	private Long saleId;
	
	@JsonProperty("status")
	private Boolean status;
	
	@JsonProperty("createdAt")
	private Date createdAt;

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
