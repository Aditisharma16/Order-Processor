package com.orderprocessor.web.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.orderprocessor.model.service.product.ProductService;

/**
 * @author VE00YM341
 * @createdOn 17/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
@Controller
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	

	/**
	* @author VE00YM341
	* get all products
	* @param ModelAndView mv
	* @return ModelAndView
	* @throws Exception
	*/
	@GetMapping(path = "/products")
	public ModelAndView getAllProducts(ModelAndView mv) {
		try {
		mv.addObject("products",productService.getAllProducts());
		mv.setViewName("products");
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return mv;
	}	
	
}
