package com.orderprocessor.web.controller.cart;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.orderprocessor.model.dao.order.Order;
import com.orderprocessor.model.dao.order_product.CompositeOrderProductKey;
import com.orderprocessor.model.dao.order_product.OrderProduct;
import com.orderprocessor.model.dto.cart.Cart;
import com.orderprocessor.model.dto.order.AddOrderDto;
import com.orderprocessor.model.dto.order.AddOrderForm;
import com.orderprocessor.model.service.order.OrderService;
import com.orderprocessor.model.service.order_product.OrderProductService;
import com.orderprocessor.model.service.product.ProductService;

/**
 * @author VE00YM341
 * @version : 1.0
 * @CreatedOn : 19-03-2022
 * @updated on :
 * @updated by :
 *
 */
@Controller
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderProductService orderProductService;
	
	private  static final String CARTLISTSTRING = "cart-list";
	private static final String PRODUCTEXISTS = "product_exists";
	private static final String REDIRECTPRODUCTS="redirect:products";
    private static final String REDIRECTCHECKOUT="redirect:checkout";

	/**
	* @author VE00YM341
	* add product to cart
	* @param Model m, Long id, HttpSession session, RedirectAttributes rm 
	* @return String
	* @throws Exception
	*/
	@GetMapping("add-to-cart")
	public String addtoCart(Model m, @RequestParam(name = "id") Long id, HttpSession session, RedirectAttributes rm) {

		try {
			ArrayList<Cart> cartList = new ArrayList<>();
			Cart cm = new Cart();
			cm.setId(id);
			cm.setQuantity(1);

			ArrayList<Cart> cartListAttribute = (ArrayList<Cart>) session.getAttribute(CARTLISTSTRING);

			if (cartListAttribute == null) {
				cartList.add(cm);
				session.setAttribute(CARTLISTSTRING, cartList);
				
				rm.addFlashAttribute(PRODUCTEXISTS, false);
			} else {
				cartList = cartListAttribute;
				boolean exist = false;

				for (Cart c : cartListAttribute) {
					if (c.getId().equals(id) ) {
						exist = true;
						
						rm.addFlashAttribute(PRODUCTEXISTS, true);
					}
				}
				if (!exist) {
					cartList.add(cm);
					rm.addFlashAttribute(PRODUCTEXISTS, false);
				}
				
			}

		} catch (Exception ex) {
			ex.getMessage();
		}
		return REDIRECTPRODUCTS;
	}
	
	/**
	* @author VE00YM341
	* quantity increment
	* @param Long id, HttpSession session, String action
	* @return String
	* @throws Exception
	*/
	@GetMapping("quantity-inc")
	public String doInc(@RequestParam(name = "id") Long id, @RequestParam(name = "action") String action,
			HttpSession session) {
		try {
			ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute(CARTLISTSTRING);

			if (action != null && id >= 1) {
					for (Cart c : cartList) {
						if (c.getId().equals(id)) {
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
						}
				}	
			} else {
				return REDIRECTPRODUCTS;
			}

		} catch (Exception ex) {
			ex.getMessage();
		}
		return REDIRECTCHECKOUT;
	}

	
	/**
	* @author VE00YM341
	* quantity decrement
	* @param Long id, HttpSession session, String action
	* @return String
	* @throws Exception
	*/
	@GetMapping("quantity-dec")
	public String doIncDec(@RequestParam(name = "id") Long id, @RequestParam(name = "action") String action,
			HttpSession session) {
		try {
			ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute(CARTLISTSTRING);

			if (action != null && id >= 1) {
					for (Cart c : cartList) {
						if (c.getId().equals(id) && c.getQuantity() > 1) {
							int quantity = c.getQuantity();
							quantity--;
							c.setQuantity(quantity);
						}
					}
				
			} else {
				return REDIRECTPRODUCTS;
			}

		} catch (Exception ex) {
			ex.getMessage();
		}
		return REDIRECTCHECKOUT;
	}
	
	
	/**
	* @author VE00YM341
	* remove product from cart
	* @param Long id, HttpSession session
	* @return String
	* @throws Exception
	*/
	@GetMapping("remove-from-cart")
	public String doRemoveFromCart(@RequestParam(name="id") Long id, HttpSession session) {
		
		try {
			if (id != null) {
				ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute(CARTLISTSTRING);
				if (cartList != null) {
					for (Cart c : cartList) {
						if (c.getId().equals(id)) {
							cartList.remove(productService.getIndex(id, cartList));
							break;
						}
					}
				}
			} else {
				return REDIRECTPRODUCTS;
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return REDIRECTCHECKOUT;
	}

	/**
	* @author VE00YM341
	* remove product from cart
	* @param ModelAndView mv, HttpSession session
	* @return ModelAndView 
	* @throws Exception
	*/
	
	@GetMapping(path="checkout")
	public ModelAndView addOrders(ModelAndView mv, HttpSession session,RedirectAttributes rm) {
		
		try {
			ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute(CARTLISTSTRING);
			if (cartList != null && !cartList.isEmpty()) {
				rm.addFlashAttribute("cart_empty", false);
				mv.addObject("checkProducts", productService.getCartProducts(cartList));
				mv.addObject("totalPrice", productService.getTotalCartPrice(cartList));
				mv.addObject("addOrderForm", new AddOrderForm());
				mv.setViewName("createorder");
			} else {
				rm.addFlashAttribute("cart_empty", true);
				mv.setViewName(REDIRECTPRODUCTS);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return mv;
	}
	
	
	/**
	* @author VE00YM341
	* place order
	* @param ModelAndView mv, AddOrderForm addOrderForm
	* @return ModelAndView 
	* @throws Exception
	*/
	 @PostMapping("place-order")
	public ModelAndView placeOrder(ModelAndView mv,@ModelAttribute(name = "addOrderForm") AddOrderForm addOrderForm,
			RedirectAttributes rm,HttpSession session, Principal principal) {
		
		try {
			ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute(CARTLISTSTRING);

			if (cartList != null) {
				AddOrderDto dto = new AddOrderDto(addOrderForm.getShippingAddress(), addOrderForm.getCustomerName(),
						addOrderForm.getCustomerPhoneno(), productService.getTotalCartPrice(cartList),
						principal.getName(), LocalDateTime.now());
				Order order = orderService.addOrder(dto);
				for (Cart c : cartList) {
					CompositeOrderProductKey key = new CompositeOrderProductKey(order.getId(), c.getId());
					OrderProduct orderProduct = new OrderProduct(key, c.getQuantity());
					orderProductService.addOrderProduct(orderProduct);
				}
				session.setAttribute(CARTLISTSTRING, null);
				rm.addFlashAttribute("orderplaced", true);
				mv.setViewName(REDIRECTPRODUCTS);
			} else {
				rm.addFlashAttribute("orderplaced", false);
				mv.setViewName(REDIRECTPRODUCTS);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return mv;
	}
}
