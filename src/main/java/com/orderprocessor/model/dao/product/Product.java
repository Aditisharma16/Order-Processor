package com.orderprocessor.model.dao.product;

import java.time.LocalDateTime;

import javax.persistence.Column;
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
 * @createdOn 16/03/2022
 * @version : 1.0
 * @updated on :17/03/2022
 * @updated by : Aditi
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product_master")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="product_name", nullable=false)
	private String productName;
	
	@Column(name="product_price",nullable=false)
	private Double productPrice;
	
	@Column(name="created_by")
	private String productCreatedBy;
	
	@Column(name="created_on")
	private LocalDateTime productCreatedOn;
	
	@Column(name="updated_by")
	private String productUpdatedBy;
	
	@Column(name="updated_on")
	private LocalDateTime productUpdatedOn;
	
	@Column(name="is_deleted")
	private boolean isProductDeleted;
	@Column(name="img_path")
	private String path;

	public Product(String productName, Double productPrice, String createdBy, LocalDateTime createdOn, String path) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCreatedBy = createdBy;
		this.productCreatedOn = createdOn;
		this.path = path;
	}
	
	
}
