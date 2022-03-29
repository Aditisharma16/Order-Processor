package com.orderprocessor.model.dto.cart;

import java.io.Serializable;

import com.orderprocessor.model.dao.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author VE00YM341
 * @version : 1.0
 * @CreatedOn : 19-03-2022
 * @updated on :
 * @updated by :
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer quantity;
	
}
