package com.trade.shipping.model;

import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Sale Model")
public class Sale extends BaseModel{
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Sale id")
	private Long id;
	
	@ApiModelProperty(notes = "Sale code")
	private UUID code;
	
	public Sale(Long id, UUID code) {
		this.id = id;
		this.code = code;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public UUID getCode() {
		return code;
	}
	public void setCode(UUID code) {
		this.code = code;
	}
	
	
}
