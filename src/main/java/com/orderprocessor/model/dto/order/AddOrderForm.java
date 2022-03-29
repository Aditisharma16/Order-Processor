package com.orderprocessor.model.dto.order;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author VE00YM341
 * @createdOn 17/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddOrderForm implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String shippingAddress;
	private String customerName;
	private String customerPhoneno;
}
