package com.challenge.usermanagement.dao;

import java.util.List;

import com.challenge.usermanagement.domain.User;

/**
 * Created by venkateshr on 31/7/16.
 */
public interface UserDao {
	
	public long saveUser(User user);
	
	public void updateUser(User user);
	
	public List<User> getAllUsers();
	
	public User findUserById(long id);
}
