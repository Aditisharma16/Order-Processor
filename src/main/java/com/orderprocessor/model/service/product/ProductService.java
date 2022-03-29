package com.orderprocessor.model.service.product;

import java.util.List;

import com.orderprocessor.model.dao.product.Product;
import com.orderprocessor.model.dto.cart.Cart;
import com.orderprocessor.model.exception.ProductNotFoundException;

/**
 * @author VE00YM341
 * @createdOn 17/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by : 
 *
 */


public interface ProductService{
	
	/**
	* @author VE00YM341
	* add product
	* @param Product object 
	* @return product
	* @throws 
	*/
	public Product addProduct(Product product);
	
	/**
	* @author VE00YM341
	* get product by id
	* @param Product id 
	* @return Product
	* @throws ProductNotFoundException
	*/
	public Product getProductById(Long id);
	
	/**
	* @author VE00YM341
	* get all product
	* @param 
	* @return List of Product
	* @throws 
	*/
	public List<Product> getAllProducts();
	
	/**
	* @author VE00YM341
	* get cart product
	* @param ArrayList of cart
	* @return List of cart Product
	* @throws ProductNotFoundException
	*/
	public List<Cart> getCartProducts(List<Cart> cartList);
	
	/**
	* @author VE00YM341
	* get total cart price
	* @param ArrayList of cart
	* @return Double 
	* @throws 
	*/
	public Double getTotalCartPrice(List<Cart> cartList);
	
	/**
	* @author VE00YM341
	* get index of cart which we have to remove
	* @param Long id, ArrayList of cart
	* @return int 
	* @throws 
	*/
	public int getIndex(Long id, List<Cart> cart);
}
