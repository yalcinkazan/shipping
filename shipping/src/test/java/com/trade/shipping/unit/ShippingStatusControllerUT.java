package com.trade.shipping.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.trade.shipping.controller.ShippingStatusController;
import com.trade.shipping.enums.ShippingStatusType;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShippingStatusControllerUT {
	
    @Autowired
    private ShippingStatusController shippingStatusController;
    
    private MockMvc mockMvc;
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.shippingStatusController).build();
    }
    
    @Test
    public void shippingStatusTest() throws Exception {
        this.mockMvc.perform(get("/sale/3/shipping").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status", is(ShippingStatusType.NOT_DELIVERED.getStatus())));
    }
    
    @Test
    public void shippingStatusSaleTest() throws Exception {
        this.mockMvc.perform(get("/sale/3/shipping").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.sale.id", is(3)))
        	.andExpect(jsonPath("$.sale.code", is("0c784421-3cbb-4566-ab72-06628413758b")));
    }
    
    @Test
    public void shippingStatusProductTest() throws Exception {
        this.mockMvc.perform(get("/sale/3/shipping").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.product.id", is(15)))
        	.andExpect(jsonPath("$.product.name", is("Generic Concrete Ball")))
        	.andExpect(jsonPath("$.product.price", is(113.0)));
    }
    
    @Test
    public void shippingStatusResponseTest() throws Exception {
    	this.mockMvc.perform(get("/sale/3/shipping").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status", is(ShippingStatusType.NOT_DELIVERED.getStatus())))
            .andExpect(jsonPath("$.sale.id", is(3)))
        	.andExpect(jsonPath("$.sale.code", is("0c784421-3cbb-4566-ab72-06628413758b")))
        	.andExpect(jsonPath("$.product.id", is(15)))
        	.andExpect(jsonPath("$.product.name", is("Generic Concrete Ball")))
        	.andExpect(jsonPath("$.product.price", is(113.0)));
    }
    
    @Test
    public void shippingStatusProductNullTest() throws Exception {
        this.mockMvc.perform(get("/sale/1/shipping").contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.status", is(ShippingStatusType.NOT_DELIVERED.getStatus())))
	        .andExpect(jsonPath("$.sale.id", is(1)))
	    	.andExpect(jsonPath("$.sale.code", is("a8a2700a-eb48-4265-b74a-f89da5ef0a14")))
	    	.andExpect(jsonPath("$.product", nullValue()));
    }
    
}
