package com.orderprocessor.model.dao.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author VE00YM341
 * @createdOn 16/03/2022
 * @version : 1.0
 * @updated on :
 * @updated by :
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_master")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_name",nullable=false)
	private String username;
	
	@Column(name="user_password",nullable=false)
	private String password;
	
	@Column(name="user_email",nullable=false)
	private String email;
	
	@Column(name="created_by")
	private String userCreatedBy;
	
	@Column(name="created_on")
	private LocalDateTime userCreatedOn;
	
	@Column(name="updated_by")
	private String userUpdatedBy;
	
	@Column(name="updated_on")
	private LocalDateTime userUpdatedOn;
	
	@Column(name="is_deleted")
	private boolean isUserDeleted;
	
	
	User(String uname,String pass){
		this.username=uname;
		this.password=pass;
	}
	
	public User(String username, String password, String email, String createdBy,String updatedBy,
			LocalDateTime updatedOn, boolean isDeleted) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.userCreatedBy = createdBy;
		this.userCreatedOn = LocalDateTime.now();
		this.userUpdatedBy = updatedBy;
		this.userUpdatedOn = updatedOn;
		this.isUserDeleted = isDeleted;
		
	}
	
	
	
	
	
	
}
