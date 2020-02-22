package com.trade.shipping.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.trade.shipping.exception.InternalServerErrorException;
import com.trade.shipping.exception.SalesNotFoundException;
import com.trade.shipping.exception.model.InternalServerError;
import com.trade.shipping.exception.model.SalesNotFoundError;

@ControllerAdvice
public class ShippingStatusControllerAdvice {
	
	@ExceptionHandler(SalesNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public SalesNotFoundError handleSecurityException(SalesNotFoundException salesNotFoundException) {
		SalesNotFoundError salesErrorResponse = new SalesNotFoundError(salesNotFoundException.getErrorTime(), salesNotFoundException.getErrorCode(),
				salesNotFoundException.getErrorMessage(), salesNotFoundException.getSaleId());
        return salesErrorResponse;
    }
	
	@ExceptionHandler(InternalServerErrorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public InternalServerError handleSecurityException(InternalServerErrorException internalServerErrorException) {
		InternalServerError internalServerErrorResponse = new InternalServerError(internalServerErrorException.getErrorTime(),
				internalServerErrorException.getErrorCode(), internalServerErrorException.getThrowable().getClass().getName());
        return internalServerErrorResponse;
    }
	
}
