package com.trade.shipping.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.trade.shipping.ShippingApplication;
import com.trade.shipping.dto.ShippingStatusResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = ShippingApplication.class
)
@AutoConfigureMockMvc
public class ShippingStatusControllerIT {
	
	@Autowired
    private TestRestTemplate testRestTemplate;
	 
	private String okResponseUrl, notFoundResponseUrl;
	
	@Before
    public void setup() throws Exception {
        this.okResponseUrl = "/sale/3/shipping";
        this.notFoundResponseUrl = "/sale/333/shipping";
    }
	
	@Test
    public void shippingStatusOkResponseTest() {
    	 ResponseEntity<ShippingStatusResponse> shippingStatusResponse = this.testRestTemplate.getForEntity(this.okResponseUrl, ShippingStatusResponse.class);
         assertEquals(HttpStatus.OK, shippingStatusResponse.getStatusCode());
    }
	
	@Test
    public void shippingStatusNotFoundResponseTest() {
    	 ResponseEntity<ShippingStatusResponse> shippingStatusResponse = this.testRestTemplate.getForEntity(this.notFoundResponseUrl, ShippingStatusResponse.class);
         assertEquals(HttpStatus.NOT_FOUND, shippingStatusResponse.getStatusCode());
    }

}
