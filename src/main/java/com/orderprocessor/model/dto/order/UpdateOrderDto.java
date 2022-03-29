package com.orderprocessor.model.dto.order;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author VE00YM341
 * @version : 1.0
 * @CreatedOn : 20-03-2022
 * @updated on :
 * @updated by :
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String orderNumber;
	private String customerName;
	private Double totalPrice;
	private String customerPhoneno;
	private String shippingAddress;
	private String updatedBy;
	private LocalDateTime updatedOn;
}
