package com.orderprocessor.model.service.order_product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderprocessor.model.dao.order_product.OrderProduct;
import com.orderprocessor.model.dao.order_product.OrderProductDao;
import com.orderprocessor.model.dao.product.Product;
import com.orderprocessor.model.dao.product.ProductDao;
import com.orderprocessor.model.dto.cart.Cart;
import com.orderprocessor.model.exception.ProductNotFoundException;
/**
 * @author VE00YM341
 * @version : 1.0
 * @CreatedOn : 18-03-2022
 * @updated on :
 * @updated by :
 *
 *
 */

@Service
public class OrderProductServiceImpl implements OrderProductService{

	private OrderProductDao orderProductDao;
	
	private ProductDao productDao;
	
	@Autowired
	public OrderProductServiceImpl(OrderProductDao orderProductDao,ProductDao productDao) {
		this.orderProductDao = orderProductDao;
		this.productDao = productDao;
	}
	
	/**
	* @author VE00YM341
	* add order product
	* @param 
	* @return order product
	* @throws 
	*/
	@Override
	public OrderProduct addOrderProduct(OrderProduct orderProduct) {
		return orderProductDao.save(orderProduct);
	}

	@Override
	public List<Cart> getProductDetails(Long orderId) {
		List<OrderProduct> orderProductList = orderProductDao.findAllByOrderId(orderId);
		ArrayList<Cart> cartList=new ArrayList<>();
		for(OrderProduct o: orderProductList) {
			Product product = productDao.findById(o.getOrderItemKey().getProductId())
					.orElseThrow(() -> new ProductNotFoundException("Product with id" + o.getOrderItemKey().getProductId()+ " is not found"));
			Cart cart = new Cart();
			cart.setId(product.getId());
			cart.setProductName(product.getProductName());
			cart.setProductPrice(product.getProductPrice());
			cart.setQuantity(o.getQuantity());
			cartList.add(cart);
			
		}
		
		return cartList;
	}

}
