package com.trade.shipping.model;

import java.io.Serializable;

public abstract class BaseModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public abstract Long getId();
	
	public abstract void setId(Long id);
}
