package com.orderprocessor.model.dao.orderstatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author VE00YM341
 * @createdOn 18/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
@Data
@Entity
@NoArgsConstructor		
@AllArgsConstructor
@Table(name="orderstatus_master")
public class OrderStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String status;

	public OrderStatus(String status) {
		
		this.status = status;
	}
	
	

}
