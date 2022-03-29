package com.orderprocessor.web.controller.order;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.orderprocessor.model.dao.order.Order;
import com.orderprocessor.model.dao.order.OrderSearch;
import com.orderprocessor.model.dto.order.UpdateOrderDto;
import com.orderprocessor.model.service.order.OrderService;
import com.orderprocessor.model.service.order_product.OrderProductService;

/**
 * @author VE00YM341
 * @createdOn 17/03/2022
 * @version : 1.0
 * @updated on :20/03/2022
 * @updated by :Aditi
 *
 */
@Controller
public class OrderController {
	
	private OrderService orderService;
	private OrderProductService orderProductService;
	
	private static final String REDIRECTORDER="redirect:orders";
	
	@Autowired
	public OrderController(OrderService orderService,OrderProductService orderProductService) {
		this.orderService = orderService;
		this.orderProductService=orderProductService;
		
	}
	/**
	* @author VE00YM341
	* get recent order
	* @param ModelAndView mv,HttpSession session
	* @return ModelAndView
	* @throws Exception
	*/

	@GetMapping(path = "/home")
	public ModelAndView getRecentOrders(ModelAndView mv,HttpSession session) {
		
		try {
		mv.addObject("orders", orderService.getRecentOrders());
		mv.addObject("totalOrder",orderService.countOfTotalOrders());
		mv.addObject("placedOrder",orderService.countOfPlacedOrders());
		mv.addObject("inProcessingOrder",orderService.countOfInProcessingOrders());
		mv.setViewName("home");
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return mv;
	}

	
	/**
	* @author VE00YM341
	* default home page
	* @param 
	* @return String
	* @throws 
	*/
	@GetMapping(path = "/")
	public String welcome() {
		return "redirect:/home";
	}
	
	/**
	* @author VE00YM341
	* get all order 
	* @param ModelAndView mv,HttpSession session
	* @return ModelAndView
	* @throws Exception
	*/
	@GetMapping(path="orders")
	public ModelAndView getAllOrders(ModelAndView mv) {
		try {
			mv.addObject("allOrders", orderService.getAllOrders());
			mv.setViewName("retrieveorder");
			mv.addObject("updateOrderDto", new UpdateOrderDto());
		} catch (Exception ex) {
			ex.getMessage();
		}
		return mv;
	}
		
	
	/**
	* @author VE00YM341
	* search order
	* @param OrderSearch search, ModelMap map
	* @return String
	* @throws Exception
	*/
	@PostMapping(value = "/search")
	public String search(OrderSearch search, ModelMap map) {

		try {
			List<Order> order = orderService.searchByOrderNumber(search.getSearch());
			map.addAttribute("allOrders", order);
		} catch (Exception ex) {
			ex.getMessage();
		}

		return "retrieveorder";

	}
	
	/**
	* @author VE00YM341
	* delete order
	* @param long id
	* @return String
	* @throws Exception
	*/
	
	@GetMapping(path = "/deleteorder")
	public String deleteOrder(@RequestParam(name = "id") long id) {
		try {
			orderService.deleteOrder(id);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return REDIRECTORDER;

	}
	/**
	* @author VE00YM341
	* update order
	* @param UpdateOrderDto dto,Principal principal
	* @return String
	* @throws Exception
	*/
	@PostMapping(path="/updateorder")
	public String getUpdateOrder(@ModelAttribute(name="updateOrderDto") UpdateOrderDto dto,Principal principal) {
		dto.setUpdatedBy(principal.getName());
		dto.setUpdatedOn(LocalDateTime.now());
		orderService.updateOrderDetails(dto);
		return REDIRECTORDER;
	}
	
	/**
	* @author VE00YM341
	* view product
	* @param id,RedirectAttributes rm
	* @return String
	* @throws Exception
	*/
	@GetMapping(path="/viewproducts")
	public String viewProduct(@RequestParam(name="id") long id, RedirectAttributes rm) {
		try {
			
			rm.addFlashAttribute("productDetails", orderProductService.getProductDetails(id));
			
			
		}catch(Exception ex)
		{
			ex.getMessage();
		}
		return REDIRECTORDER;
	}
	
}
