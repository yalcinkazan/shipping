package com.trade.shipping.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "saleCode", "productId" })
public class SalesResponse {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("saleCode")
	private UUID saleCode;
	
	@JsonProperty("productId")
	private Long productId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getSaleCode() {
		return saleCode;
	}

	public void setSaleCode(UUID saleCode) {
		this.saleCode = saleCode;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}
