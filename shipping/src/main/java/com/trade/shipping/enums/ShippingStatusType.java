package com.trade.shipping.enums;

public enum ShippingStatusType {
	
	WAS_DELIVERED("TESLİM EDİLDİ"),
	NOT_DELIVERED("TESLİM EDİLMEDİ");
	
	String status;
	
	private ShippingStatusType(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}
