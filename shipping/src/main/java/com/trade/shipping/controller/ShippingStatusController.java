package com.trade.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trade.shipping.dto.ProductsResponse;
import com.trade.shipping.dto.SalesResponse;
import com.trade.shipping.dto.ShippingResponse;
import com.trade.shipping.dto.ShippingStatusResponse;
import com.trade.shipping.enums.ShippingStatusType;
import com.trade.shipping.exception.InternalServerErrorException;
import com.trade.shipping.exception.SalesNotFoundException;
import com.trade.shipping.exception.model.InternalServerError;
import com.trade.shipping.exception.model.SalesNotFoundError;
import com.trade.shipping.service.ApiServiceImpl;
import com.trade.shipping.util.CommonUtil;
import com.trade.shipping.util.ConvertUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/sale")
public class ShippingStatusController {
	
	@Autowired
	private ApiServiceImpl apiService;
	
	@ApiOperation(value = "Get Shipping Status of Sale", response = ShippingStatusResponse.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Shipping Status Check Successful", response = ShippingStatusResponse.class),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "Sales Not Found", response = SalesNotFoundError.class),
	    @ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerError.class)
	}) 
	@GetMapping("/{saleId}/shipping")
    public ResponseEntity<ShippingStatusResponse> getShippingStatus(@ApiParam(value = "Sale Id", required = true, example = "3")
    														@PathVariable(required = true, value = "saleId") Long saleId) { 
		try {
			SalesResponse salesResponse = this.apiService.getSalesResponse(saleId);
			if(salesResponse != null) {
				ShippingResponse shippingResponse = this.apiService.getShippingResponse(saleId);
				ProductsResponse productsResponse = this.apiService.getProductResponse(salesResponse.getProductId());
				
				ShippingStatusResponse shippingStatusResponse = new ShippingStatusResponse();
				if(shippingResponse != null) {
					shippingStatusResponse.setStatus(shippingResponse.getStatus() ? ShippingStatusType.WAS_DELIVERED.getStatus() : ShippingStatusType.NOT_DELIVERED.getStatus());
				}
				shippingStatusResponse.setProduct(ConvertUtil.productsResponseToProduct(productsResponse));
				shippingStatusResponse.setSale(ConvertUtil.salesResponseToSale(salesResponse));
				
				return new ResponseEntity<ShippingStatusResponse>(shippingStatusResponse, HttpStatus.OK);
			}else {
				throw new SalesNotFoundException();
			}
		}catch (Exception e) {
			if(e instanceof SalesNotFoundException) {
				throw new SalesNotFoundException(CommonUtil.getNow(), "Sales Not Found", saleId);
			}else {
				throw new InternalServerErrorException(CommonUtil.getNow(), e);
			}
		}
    }
	
}
