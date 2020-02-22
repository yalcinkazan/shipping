package com.trade.shipping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.trade.shipping.dto.ProductsResponse;
import com.trade.shipping.dto.SalesResponse;
import com.trade.shipping.dto.ShippingResponse;

@Service
public class ApiServiceImpl implements ITApiService{
	
	@Value("${api.url}")
	private String apiUrl;
	 
	@Value("${api.sales.url}")
	private String salesUrl;
	
	@Value("${api.products.url}")
	private String productsUrl;
	
	@Value("${api.shipping.url}")
	private String shippingUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public SalesResponse getSalesResponse(Long saleId) {
		try {
			return this.restTemplate.getForObject(this.apiUrl + this.salesUrl + saleId, SalesResponse.class);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public ShippingResponse getShippingResponse(Long saleId) {
		try {
			return this.restTemplate.getForObject(this.apiUrl + this.shippingUrl + saleId, ShippingResponse.class);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public ProductsResponse getProductResponse(Long productId) {
		try {
			return this.restTemplate.getForObject(this.apiUrl + this.productsUrl + productId, ProductsResponse.class);
		} catch (Exception e) {
			return null;
		}
	}
}
