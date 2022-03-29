package com.orderprocessor.model.dto.order;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author VE00YM341
 * @CreatedOn : 22/03/2022
 * @UpdatedOn : 
 * @UpdatedBy : 
 * This Dto is used to convert timestamp to date
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateOrderDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Long id;
	private String orderNumber;
	private String shippingAddress;
	private String deliveryDate;
	private String customerName;
	private String customerPhoneno;
	private Double totalPrice;
	private String createdBy;
	private String createdOn;
	private String updatedBy;
	private String updatedOn;
	private boolean isDeleted;
	private Integer statusId;

}
