package com.trade.shipping.util;

import com.trade.shipping.dto.ProductsResponse;
import com.trade.shipping.dto.SalesResponse;
import com.trade.shipping.model.Product;
import com.trade.shipping.model.Sale;

public class ConvertUtil {
	
	/**
	 * Product response to product object, if there is no products response return null
	 * 
	 * @param productsResponse ProductsResponse object
	 * @return Product
	 */
	public static Product productsResponseToProduct(ProductsResponse productsResponse) {
		if(productsResponse != null) {
			return new Product(productsResponse.getId(), productsResponse.getName(), productsResponse.getPrice());
		}
		return null;
	}
	
	/**
	 * Sales response to sale object,  if there is no sales response return null
	 *  
	 * @param salesResponse SalesResponse object
	 * @return Sale
	 */
	public static Sale salesResponseToSale(SalesResponse salesResponse) {
		if(salesResponse != null) {
			return new Sale(salesResponse.getId(), salesResponse.getSaleCode());
		}
		return null;
	}
}
