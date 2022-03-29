package com.orderprocessor.model.dao.orderstatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VE00YM341
 * @createdOn 18/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 */
@Repository
public interface OrderStatusDao extends JpaRepository<OrderStatus, Integer>{
	
}
