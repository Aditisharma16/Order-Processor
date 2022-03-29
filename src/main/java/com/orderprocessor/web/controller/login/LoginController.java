package com.orderprocessor.web.controller.login;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author VE00YM341
 * @createdOn 16/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
@Controller
public class LoginController {
	
	/**
	* @author VE00YM341
	* login
	* @param 
	* @return String
	* @throws 
	*/
	
	@GetMapping(path="login")
	public String login() {
		return "login";
	}
	
	/**
	* @author VE00YM341
	* accessDenied
	* @param Principal principal, ModelAndView mv
	* @return ModelAndView
	* @throws Exception
	*/
	@GetMapping(path = "accessdenied")
	public ModelAndView accessDenied(Principal principal, ModelAndView mv) {
		
		try {
		mv.addObject("username", principal.getName());
		mv.setViewName("403");
		}catch(Exception ex)
		{
			ex.getMessage();
		}
		return mv;
	}	
	
	/**
	* @author VE00YM341
	* logout
	* @param 
	* @return String
	* @throws 
	*/
	@GetMapping("/logout")
	public String logout()
	{
	return "login";
	}
	
}
