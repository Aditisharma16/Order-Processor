package com.orderprocessor.model.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author VE00YM341
 * @createdOn 16/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
public interface UserDao extends JpaRepository<User, Long> {
	
	//This method is used to find user by their username
	public User findByUsername(String username);
	
	//This method is used to find user by their email
	public User findByEmail(String email);

}
