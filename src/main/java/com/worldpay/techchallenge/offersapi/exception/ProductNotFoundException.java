/*
 * 
 */
package com.worldpay.techchallenge.offersapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * The Class ProductNotFoundException.
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Product")  // 404
public class ProductNotFoundException extends RuntimeException {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1102690823917504133L;
   
	
	/**
	 * Instantiates a new product not found exception.
	 *
	 * @param msg 
	 */
	public ProductNotFoundException(String msg){
		super(msg);
	}
	
}