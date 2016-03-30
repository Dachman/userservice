package com.dachlab.service;

import com.dachlab.model.User;

/**
 * User management services.
 * 
 * @author dcharles
 *
 */
public interface IUserSevice {

	/**
	 * Authenticate a user.
	 * 
	 * @param userName
	 *            user name.
	 * @param password
	 *            user password.
	 * @return User found or null.
	 */
	User authenticate(String userName, String password) throws Exception;

	/**
	 * Get a user by his name.
	 * 
	 * @param userName
	 *            used name.
	 * @return User found or null.
	 */
	User getByUserName(String userName);

	/**
	 * Get a user by his Id.
	 * 
	 * @param userId
	 *            user id.
	 * @return User found or null.
	 */
	User getByUserId(Integer userId);

	/**
	 * Get the authenticated user.
	 * 
	 * @return the authenticated user.
	 */
	User getAuthenticatedUser();

}
