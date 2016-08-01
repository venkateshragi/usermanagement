package com.challenge.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.usermanagement.domain.User;
import com.challenge.usermanagement.service.UserService;

/**
 * Created by venkateshr on 31/7/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Long> saveUser(@RequestBody User user) {
		long userId = userService.saveUser(user);
		return new ResponseEntity<Long>(userId, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Boolean> updateUser(@RequestBody User user, @PathVariable("id") long userId) {
		User fetchedUser = userService.findUserById(userId);
		if(fetchedUser == null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		fetchedUser.setPhone(user.getPhone());
		userService.updateUser(fetchedUser);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
}
