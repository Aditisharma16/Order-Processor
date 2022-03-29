package com.orderprocessor.utils;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.orderprocessor.model.dao.order.Order;
import com.orderprocessor.model.dao.orderstatus.OrderStatusEnum;
import com.orderprocessor.model.dto.order.AddOrderDto;

/**
 * @author VE00YM341
 * @createdOn 17/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
public class OrderDtoMapper {

	private OrderDtoMapper() {

	}

	/**
	* @author VE00YM341
	* addConvertToOrder
	* @param AddOrderDto
	* @return Order
	* @throws 
	*/
	public static Order addConvertToOrder(AddOrderDto dto) {
		LocalTime time = LocalTime.now();
		Order order = new Order();
		order.setShippingAddress(dto.getShippingAddress());
		order.setCustomerName(dto.getCustomerName());
		order.setCustomerPhoneno(dto.getCustomerPhoneno());
		order.setTotalPrice(dto.getTotalPrice());
		order.setCreatedBy(dto.getCreatedBy());
		order.setUpdatedBy(null);
		order.setUpdatedOn(null);
		order.setDeleted(false);
		order.setDeliveryDate(LocalDateTime.now().plusDays(new SecureRandom().nextInt(4) +(long)5));
		order.setOrderNumber(
				"OP" + (new SecureRandom().nextInt(899) + 100) + time.getHour() + time.getMinute() + time.getSecond());
		order.setCreatedOn(LocalDateTime.now());
		order.setStatusId(OrderStatusEnum.PLACED.getVal());
		return order;
	}

}
