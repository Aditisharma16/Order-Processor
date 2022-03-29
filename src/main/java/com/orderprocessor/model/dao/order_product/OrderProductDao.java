package com.orderprocessor.model.dao.order_product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author VE00YM341
 * @version : 1.0
 * @CreatedOn : 18-03-2022
 * @updated on :
 * @updated by :
 *
 *
 */
@Repository
public interface OrderProductDao extends JpaRepository<OrderProduct, CompositeOrderProductKey>{
	
	@Query("Select o from OrderProduct o where o.orderItemKey.orderId = :orderId")
	List<OrderProduct> findAllByOrderId(@Param("orderId") Long orderId);
}
