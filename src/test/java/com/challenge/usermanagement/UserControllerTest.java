package com.challenge.usermanagement;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.BeforeMethod;

import com.challenge.usermanagement.controller.UserController;
import com.challenge.usermanagement.domain.Gender;
import com.challenge.usermanagement.domain.User;
import com.challenge.usermanagement.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	@Mock
	UserService userService;
	
	UserController userController;
	
	@Before
	public void initialize(){
		MockitoAnnotations.initMocks(this);
		
		userController = new UserController();
		userController.setUserService(userService);
	}
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setFirstname("check");
		user.setLastname("last");
		user.setAge(25);
		user.setGender(Gender.M);
		user.setPhone("1234567890");
		
		when(userService.saveUser(user)).thenReturn(1l);
		
		ResponseEntity<Long> responseEntity = userController.saveUser(user);
		assert responseEntity.getBody() == 1l;	
		
	}
}
