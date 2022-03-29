package com.orderprocessor.model.service.order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderprocessor.model.dao.order.Order;
import com.orderprocessor.model.dao.order.OrderDao;
import com.orderprocessor.model.dao.orderstatus.OrderStatusEnum;
import com.orderprocessor.model.dto.order.AddOrderDto;
import com.orderprocessor.model.dto.order.DateOrderDto;
import com.orderprocessor.model.dto.order.DateOrderMapper;
import com.orderprocessor.model.dto.order.UpdateOrderDto;
import com.orderprocessor.utils.OrderDtoMapper;


/**
 * @author VE00YM341
 * @version : 1.0
 * @CreatedOn : 17-03-2022
 * @updated on :
 * @updated by :
 *
 *This class is used to implement all the methods declared in OrderService using orderDao object
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao;
	
	@Autowired
	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	/**
	* @author VE00YM341
	* Get all orders
	* @param 
	* @return List of order
	* @throws 
	*/
	@Override
	public List<DateOrderDto> getAllOrders() {
		 List<Order> order = orderDao.findActiveOrders();
		 return DateOrderMapper.convertToDateOrder(order);
	}

	/**
	* @author VE00YM341
	* Get order by id
	* @param order id
	* @return order
	* @throws 
	*/
	@Override
	public Order getOrderById(Long orderId) {
		return orderDao.getById(orderId);
	}

	/**
	* @author VE00YM341
	* add new order 
	* @param addorder dto (shippingAddress,customerName,customerPhoneno,totalPrice,createdBy,createdOn)
	* @return order
	* @throws 
	*/
	@Override
	public Order addOrder(AddOrderDto orderdto) {
		  
		Order order = OrderDtoMapper.addConvertToOrder(orderdto);
		return orderDao.save(order);
		
	}

	/**
	* @author VE00YM341
	* update order 
	* @param updateorder dto (orderNumber,shippingAddress,customerName,customerPhoneno,totalPrice,updatedBy,updatedOn)
	* @return order
	* @throws 
	*/
	@Override
	public Order updateOrderDetails(UpdateOrderDto orderDetail) {
		Order order = orderDao.getById(orderDetail.getId());
		order.setCustomerPhoneno(orderDetail.getCustomerPhoneno());
		order.setShippingAddress(orderDetail.getShippingAddress());
		order.setUpdatedBy(orderDetail.getUpdatedBy());
		order.setUpdatedOn(orderDetail.getUpdatedOn());
		return order;
	}

	/**
	* @author VE00YM341
	* delete order 
	* @param order id
	* @return order
	* @throws 
	*/
	@Override
	public Order deleteOrder(Long orderId) {
		Order order = orderDao.getById(orderId);
		order.setStatusId(OrderStatusEnum.DELETED.getVal());
		order.setDeleted(true);
		orderDao.save(order);
		return order;
	}


	/**
	* @author VE00YM341
	* get recent orders 
	* @param 
	* @return List of order
	* @throws 
	* getting recent order , update order status, convert timestamp into date
	*/
	@Override
	public List<DateOrderDto> getRecentOrders() {
		updateOrderStatusAfter24Hrs();
		updateOrderStatusDelivered();
		List<Order> order = orderDao.findAllWithCreationTime();
		 return DateOrderMapper.convertToDateOrder(order); 
		
	}

	/**
	* @author VE00YM341
	* get count of total orders 
	* @param 
	* @return Integer
	* @throws 
	*/
	@Override
	public Integer countOfTotalOrders() {
		
		return orderDao.countTotalOrders();
	}

	/**
	* @author VE00YM341
	* get count of placed orders 
	* @param 
	* @return Integer
	* @throws 
	*/
	@Override
	public Integer countOfPlacedOrders() {
		
		return orderDao.countPlacedOrders();
	}

	/**
	* @author VE00YM341
	* get count of in processing orders 
	* @param 
	* @return Integer
	* @throws 
	*/
	@Override
	public Integer countOfInProcessingOrders() {
		
		return orderDao.countInProcessingOrders();
	}

	/**
	* @author VE00YM341
	* search order by order number 
	* @param 
	* @return List of order
	* @throws 
	*/

	@Override
	public List<Order> searchByOrderNumber(String orderNumber) {
	
		return orderDao.findByOrderNumber(orderNumber);
	}

	
	/**
	* @author VE00YM341
	* update order status after 24 hrs
	* @param 
	* @return List of order
	* @throws 
	*/
	@Override
	public List<Order> updateOrderStatusAfter24Hrs() {
	
     
		List<Order> order = orderDao.findAllOrderAfter24hrs();
		for(Order o: order) {
			o.setStatusId(OrderStatusEnum.IN_PROCESSING.getVal());
			orderDao.save(o);
		}
		return order;
	}

	/**
	* @author VE00YM341
	* update order status after delivered
	* @param 
	* @return List of order
	* @throws 
	*/
	@Override
	public List<Order> updateOrderStatusDelivered() {
		List<Order> order = orderDao.findAllDeliveredOrder();
		for(Order o: order) {
			o.setStatusId(OrderStatusEnum.DELIVERED.getVal());
			orderDao.save(o);
		}
		return order;
	}

	
}

