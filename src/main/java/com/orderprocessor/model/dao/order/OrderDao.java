package com.orderprocessor.model.dao.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * @author VE00YM341
 * @createdOn 17/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
@Repository
public interface OrderDao extends JpaRepository<Order, Long>{
	
	/* This method is used to find most recent orders from time of creation*/
	@Query("select o from Order o where o.statusId <> 4 order by o.createdOn DESC")
	 List<Order> findAllWithCreationTime();
	
	/*This method is used to count total number of orders*/
	@Query("Select count(o) from Order o where o.statusId <> 4")
	 Integer countTotalOrders();
	
	
	/*This method is used to count newly placed orders*/
	@Query("Select count(o) from Order o where o.statusId = 1 " )
	 Integer countPlacedOrders();
	
	/*This method is used to count orders with IN PROCESSING status*/
	@Query("Select count(o) from Order o where o.statusId = 2 ")
	 Integer countInProcessingOrders();
	
	/*This method is used to find orders which are not deleted*/
	@Query("Select o from Order o where o.statusId <> 4")
	List<Order> findActiveOrders();
	
	/*This method is used for changing order status after 24 hrs*/
	@Query(value= "select * from order_master where status_id=1 and created_on <= (now() - interval '24 hour')", nativeQuery = true)
	List<Order> findAllOrderAfter24hrs();
	
	
	/*This method is used for order status which are delivered*/
	@Query(value= "select * from order_master where status_id=2 and delivery_date <= now() ", nativeQuery = true)
	List<Order> findAllDeliveredOrder();
	
	
	/*This method is used to search order by order number*/
	List<Order> findByOrderNumber(String orderNumber);
		
}


