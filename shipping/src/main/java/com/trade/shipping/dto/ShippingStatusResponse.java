package com.trade.shipping.dto;

import com.trade.shipping.model.Product;
import com.trade.shipping.model.Sale;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Shipping Status Response")
public class ShippingStatusResponse {
	
	@ApiModelProperty(notes = "Shipping status")
	private String status;
	
	@ApiModelProperty(notes = "Sale model")
	private Sale sale;
	
	@ApiModelProperty(notes = "Product model")
	private Product product;
	
	public String getStatus() {
		return status; 
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Sale getSale() {
		return sale;
	}
	
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
