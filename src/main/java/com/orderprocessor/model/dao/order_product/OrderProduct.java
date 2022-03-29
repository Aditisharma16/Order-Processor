package com.orderprocessor.model.dao.order_product;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author VE00YM341
 * @version : 1.0
 * @CreatedOn : 18-03-2022
 * @updated on :
 * @updated by :
 *
 *This class is used to make table with composite key of order id, product id and quantity
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_product_detail")
public class OrderProduct {

	@EmbeddedId
	@AttributeOverride(name = "orderId", column = @Column(name = "order_id"))
	@AttributeOverride(name = "productId", column = @Column(name = "product_id"))
	CompositeOrderProductKey orderItemKey;

	@Column(name="quantity")
	private int quantity;
}
