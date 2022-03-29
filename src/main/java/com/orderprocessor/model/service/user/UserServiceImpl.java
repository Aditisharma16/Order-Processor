package com.orderprocessor.model.service.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.orderprocessor.model.dao.user.User;
import com.orderprocessor.model.dao.user.UserDao;


/**
 * @author VE00YM341
 * @createdOn 16/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
   private PasswordEncoder passwordEncoder;
	
	/**
	* @author VE00YM341
	* add user
	* @param User
	* @return void
	* @throws 
	*/
	public void addUser(User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}
	
	/**
	* @author VE00YM341
	* find user by name
	* @param String username
	* @return User
	* @throws 
	*/

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	
}
