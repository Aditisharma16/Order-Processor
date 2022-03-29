package com.orderprocessor.model.dao.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VE00YM341
 * @createdOn 16/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Long>{

}
