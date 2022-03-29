package com.orderprocessor.model.exception;

/**
 * @author VE00YM341
 * @version : 1.0
 * @CreatedOn : 16-03-2022
 * @updated on :
 * @updated by :
 *
 */
public class ProductNotFoundException   extends RuntimeException{
	private static final long serialVersionUID = 7202047357477117930L;

	public ProductNotFoundException(String message) {
		super(message);
	}

}
