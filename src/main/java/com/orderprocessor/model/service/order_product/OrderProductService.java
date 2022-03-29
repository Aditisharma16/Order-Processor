package com.orderprocessor.model.service.order_product;

import java.util.List;

import com.orderprocessor.model.dao.order_product.OrderProduct;
import com.orderprocessor.model.dto.cart.Cart;


/**
 * @author VE00YM341
 * @version : 1.0
 * @CreatedOn : 18-03-2022
 * @updated on :
 * @updated by :
 *
 *
 */
public interface OrderProductService {
	
	public OrderProduct addOrderProduct(OrderProduct orderProduct);
	public List<Cart> getProductDetails(Long orderId);
}
