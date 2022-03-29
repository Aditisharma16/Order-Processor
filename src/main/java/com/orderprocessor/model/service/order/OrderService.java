package com.orderprocessor.model.service.order;

import java.util.List;

import com.orderprocessor.model.dao.order.Order;
import com.orderprocessor.model.dto.order.AddOrderDto;
import com.orderprocessor.model.dto.order.DateOrderDto;
import com.orderprocessor.model.dto.order.UpdateOrderDto;

/**
 * @author VE00YM341
 * @version : 1.0
 * @CreatedOn : 17-03-2022
 * @updated on :
 * @updated by :
 *
 */
   public interface OrderService {
	
	/**
	* @author VE00YM341
	* Get all orders
	* @param 
	* @return List of order
	* @throws 
	*/
	public List<DateOrderDto> getAllOrders();
	
	
	/**
	* @author VE00YM341
	* Get order by id
	* @param order id
	* @return order
	* @throws 
	*/
	public Order getOrderById(Long orderId);
	
	/**
	* @author VE00YM341
	* search order by order number 
	* @param 
	* @return List of order
	* @throws 
	*/
	public List<Order> searchByOrderNumber(String orderNumber);
	
	/**
	* @author VE00YM341
	* add new order 
	* @param addorder dto (shippingAddress,customerName,customerPhoneno,totalPrice,created_by,created_on)
	* @return order
	* @throws 
	*/
	public Order addOrder(AddOrderDto orderdto);
	
	/**
	* @author VE00YM341
	* update order 
	* @param updateorder dto (orderNumber,shippingAddress,customerName,customerPhoneno,totalPrice,updated_by,updated_on)
	* @return order
	* @throws 
	*/
	public Order updateOrderDetails(UpdateOrderDto orderDetail);
	
	/**
	* @author VE00YM341
	* delete order 
	* @param order id
	* @return order
	* @throws 
	*/
	public Order deleteOrder(Long orderId);
	
	/**
	* @author VE00YM341
	* get recent orders 
	* @param 
	* @return List of order
	* @throws 
	* getting recent order , update order status, convert timestamp into date
	*/
	public List<DateOrderDto> getRecentOrders();
	
	/**
	* @author VE00YM341
	* get count of total orders 
	* @param 
	* @return Integer
	* @throws 
	*/
	public Integer countOfTotalOrders();
	
	/**
	* @author VE00YM341
	* get count of placed orders 
	* @param 
	* @return Integer
	* @throws 
	*/
	public Integer countOfPlacedOrders();
	
	/**
	* @author VE00YM341
	* get count of in processing orders 
	* @param 
	* @return Integer
	* @throws 
	*/
	public Integer countOfInProcessingOrders();
	
	/**
	* @author VE00YM341
	* update order status after 24 hrs
	* @param 
	* @return List of order
	* @throws 
	*/
	public List<Order> updateOrderStatusAfter24Hrs();
	
	/**
	* @author VE00YM341
	* update order status after delivered
	* @param 
	* @return List of order
	* @throws 
	*/
	public List<Order> updateOrderStatusDelivered();
	
}
