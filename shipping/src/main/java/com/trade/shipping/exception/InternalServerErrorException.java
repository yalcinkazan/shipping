package com.trade.shipping.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
public class InternalServerErrorException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private Date errorTime;
	private Integer errorCode;
	private Throwable throwable;
	
	public InternalServerErrorException() {
		super(); 
	}

	public InternalServerErrorException(Date errorTime, Throwable throwable) {
		super(throwable); 
		this.errorTime = errorTime;
		this.errorCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
		this.throwable = throwable;
    }

	public Date getErrorTime() {
		return errorTime;
	}

	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
	
}