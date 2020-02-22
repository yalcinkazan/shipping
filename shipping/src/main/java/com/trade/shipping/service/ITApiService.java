package com.trade.shipping.service;

import com.trade.shipping.dto.ProductsResponse;
import com.trade.shipping.dto.SalesResponse;
import com.trade.shipping.dto.ShippingResponse;

public interface ITApiService {
	
	public SalesResponse getSalesResponse(Long saleId);
	
	public ShippingResponse getShippingResponse(Long saleId);
	
	public ProductsResponse getProductResponse(Long productId);
}
