package com.orderprocessor.model.exception;

/**
 * @author VE00YM341
 * @version : 1.0
 * @CreatedOn : 17-03-2022
 * @updated on :
 * @updated by :
 *
 *This class is used if order is not found
 */
public class OrdersNotFoundException   extends RuntimeException{
	private static final long serialVersionUID = 7202047357477117930L;
	

	public OrdersNotFoundException(String message) {
		super(message);
	}

}
