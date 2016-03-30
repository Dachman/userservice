package com.dachlab.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dachlab.model.User;

@Repository("userRepository")
public interface IUserRepository extends CrudRepository<User, Integer> {

	@Query("Select u from User u where u.userName=?1")
	User getByUserName(String userName);

	@Query("Select u from User u where u.userId=?1")
	User getByUserId(int userId);

	@Query("select u from User u where u.userName=?1 and u.userPassword=?2")
	User authenticate(String userName, String userPassword);
	
}
