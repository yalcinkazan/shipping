package com.trade.shipping.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Product Model")
public class Product extends BaseModel{
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Product id")
	private Long id;
	
	@ApiModelProperty(notes = "Product name")
	private String name;
	
	@ApiModelProperty(notes = "Product price")
	private Double price;
	
	public Product(Long id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
