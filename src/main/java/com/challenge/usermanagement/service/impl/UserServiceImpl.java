package com.challenge.usermanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.usermanagement.dao.UserDao;
import com.challenge.usermanagement.domain.User;
import com.challenge.usermanagement.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public long saveUser(User user) {
		return userDao.saveUser(user);
	}
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	public User findUserById(long id) {
		return userDao.findUserById(id);
	}

}
