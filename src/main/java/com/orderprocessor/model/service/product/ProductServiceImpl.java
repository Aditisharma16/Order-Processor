package com.orderprocessor.model.service.product;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderprocessor.model.dao.product.Product;
import com.orderprocessor.model.dao.product.ProductDao;
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

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	
	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	* @author VE00YM341
	* add product
	* @param Product object 
	* @return product
	* @throws 
	*/
	@Override
	public Product addProduct(Product product) {
		productDao.save(product);
		return product;
	}

	/**
	* @author VE00YM341
	* get product by id
	* @param Product id 
	* @return Product
	* @throws ProductNotFoundException
	*/
	@Override
	public Product getProductById(Long id) {
		return productDao.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product with id" + id + " is not found"));

	}

	/**
	* @author VE00YM341
	* get all product
	* @param 
	* @return List of Product
	* @throws 
	*/
	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}


	/**
	* @author VE00YM341
	* get cart product
	* @param ArrayList of cart
	* @return List of cart Product
	* @throws ProductNotFoundException
	*/
	@Override
	public List<Cart> getCartProducts(List<Cart> cartList){
		List<Cart> products = new ArrayList<>();
		if (!cartList.isEmpty()) {
			for (Cart item : cartList) {
				Product cart = getProductById(item.getId());
				Cart row = new Cart();
				row.setId(cart.getId());
				row.setProductName(cart.getProductName());
				row.setProductPrice(cart.getProductPrice());
				row.setQuantity(item.getQuantity());
				products.add(row);
			}
		}
		return products;
	}
	
	/**
	* @author VE00YM341
	* get total cart price
	* @param ArrayList of cart
	* @return Double 
	* @throws 
	*/

	@Override
	public Double getTotalCartPrice(List<Cart> cartList) {
		Double sum=0.0;
		if(!cartList.isEmpty()) {
			for(Cart item: cartList) {
				Product cart = getProductById(item.getId());
				sum+=cart.getProductPrice()*item.getQuantity();
			}
		}
		return sum;
	}
	
	/**
	* @author VE00YM341
	* get index of cart which we have to remove
	* @param Long id, ArrayList of cart
	* @return int 
	* @throws 
	*/
	
	public int getIndex(Long id, List<Cart> cart) {
		for(int i=0; i<cart.size();i++) {
			if(id.equals(cart.get(i).getId()))
				return i;
		}
		return -1;
		
	}
}
