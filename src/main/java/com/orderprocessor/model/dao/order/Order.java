package com.orderprocessor.model.dao.order;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.orderprocessor.model.dao.orderstatus.OrderStatusEnum;

import lombok.Data;

/**
 * @author VE00YM341
 * @createdOn 17/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
@Data
@Entity
@Table(name = "order_master")
public class Order {

	public Order() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "order_number", nullable = false, unique = true)
	private String orderNumber;

	@Column(name = "shipping_address", nullable = false)
	private String shippingAddress;

	@Column(name = "delivery_date", nullable = false)
	private LocalDateTime deliveryDate;

	@Column(name = "customer_name", nullable = false)
	private String customerName;

	@Column(name = "customer_phoneno", nullable = false)
	private String customerPhoneno;

	@Column(name = "total_price", nullable = false)
	private Double totalPrice;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@Column(name = "status_id")
	private Integer statusId;

	public Order(String shippingAddress, String customerName, String customerPhoneno, Double totalPrice,
			String createdBy, String updatedBy, LocalDateTime updatedOn) {
		LocalTime time = LocalTime.now();
		this.orderNumber = "OP" + (new SecureRandom().nextInt(899) + 100) + time.getHour() + time.getMinute()
				+ time.getSecond();
		this.shippingAddress = shippingAddress;
		this.deliveryDate = LocalDateTime.now().plusDays(new SecureRandom().nextInt(4) + (long) 5);
		this.customerName = customerName;
		this.customerPhoneno = customerPhoneno;
		this.totalPrice = totalPrice;
		this.createdBy = createdBy;
		this.createdOn = LocalDateTime.now();
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.isDeleted = false;
		this.statusId = OrderStatusEnum.PLACED.getVal();
	}

}
