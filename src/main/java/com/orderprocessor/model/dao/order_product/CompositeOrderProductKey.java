package com.orderprocessor.model.dao.order_product;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author VE00YM341
 * @version : 1.0
 * @createdOn : 18/03/2022
 * @updated on :
 * @updated by :
 *
 *This class is used to make composite key of orderid and product id
 */
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CompositeOrderProductKey implements Serializable{

	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Long orderId;
		private Long productId;
			
}
