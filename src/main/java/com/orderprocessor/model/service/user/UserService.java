package com.orderprocessor.model.service.user;

import com.orderprocessor.model.dao.user.User;


/**
 * @author VE00YM341
 * @createdOn 16/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
public interface UserService {
	public void addUser(User user);
	public User findByUsername(String username);

}
