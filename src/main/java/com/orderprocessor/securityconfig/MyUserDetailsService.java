package com.orderprocessor.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.orderprocessor.model.dao.user.User;
import com.orderprocessor.model.service.user.UserService;

/**
 * @author VE00YM341
 * @createdOn 16/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

private UserService userService;
	
	@Autowired
	public MyUserDetailsService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	* @author VE00YM341
	* load user
	* @param String username
	* @return UserDetails
	* @throws UsernameNotFoundException
	*/
	@Override
	public UserDetails loadUserByUsername(String username){
		User user= userService.findByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("User is not found");
		}
		
		// need to convert our User into User form UserDetails that spring security understands
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
	}
	

}
