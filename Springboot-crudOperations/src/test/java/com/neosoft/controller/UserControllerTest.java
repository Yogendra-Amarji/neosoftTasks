package com.neosoft.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neosoft.entities.User;
import com.neosoft.repository.UserRepository;
import com.neosoft.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	@Test
	public void registerUserTest() {
		User user = new User(5L, "Pranav", "Choudhary", "Pranav@Gmail.com", "442905", "2345432345", "active",
				new Date(), new Date());
		when(userService.registerUser(user)).thenReturn(user);
		User result = userController.registerUser(user);
		assertEquals(user, result);
	}
	
	@Test
	public void updateUserTest() {
	User user=new User(5L, "Pranav", "Choudhary", "Pranav@Gmail.com", "442905", "2345432345", "active",
			new Date(), new Date());
	long id=user.getUid();
	when(userService.updateUser(id, user)).thenReturn(user);
	User result=userController.updateUser(id, user);
	Assert.assertNotNull(result);
	assertEquals(user, result);
	}
	

	@Test
	public void showAllUserTest() {
		when(userService.showAllUser()).thenReturn(Stream.of(new User(5l, "Pranav", "Choudhary", "Pranav@Gmail.com",
				"442905", "2345432345", "active", new Date(), new Date())).collect(Collectors.toList()));
		Assert.assertEquals(1, userController.showAllUser().size());
	}

	@Test
	public void getUserbyfirstameTest() {
		List<User> list = new ArrayList<>();
		String firstname = "Mayank";
		when(userService.getUserbyfirstame(firstname)).thenReturn(list);
		List<User> user = userController.getUserbyfirstame(firstname);
		Assert.assertNotNull(user);
	}

	@Test
	public void searchUserbylastNameTest() {
		List<User> list = new ArrayList<>();
		String lastname = "Bhandakkar";
		when(userService.searchUserbylastName(lastname)).thenReturn(list);
		List<User> user = userController.searchUserbylastName(lastname);
		Assert.assertNotNull(user);
	}

	@Test
	public void searchUserbyPinCodeTest() {
		List<User> list = new ArrayList<>();
		String pincode = "442905";
		when(userService.searchUserbyPinCode(pincode)).thenReturn(list);
		List<User> user = userController.searchUserbyPinCode(pincode);
		Assert.assertNotNull(user);
	}
	
	@Test
	public void deleteUserbyid() {
		User user = new User(5L, "Pranav", "Choudhary", "Pranav@Gmail.com", "442905", "2345432345", "active",
				new Date(), new Date());
		long id = user.getUid();
		userController.deleteUserbyid(id);
		verify(userService, times(1)).deleteUserbyid(id);
	}
	
	@Test
	public void sortUserbydobTest() {
		List<User> listuser=new ArrayList<>();
		String dob="2021";
		when(userService.sortUserbydob()).thenReturn(listuser);
		List<User> result=userController.sortUserbydob();
	    Assert.assertNotNull(result);
	}
	
	@Test
	public void sortUserbyjoiningdateTest() {
		List<User> listuser=new ArrayList<>();
		String joiningdate="2021";
		when(userService.sortUserbyjoiningdate()).thenReturn(listuser);
		List<User> result=userController.sortUserbyjoiningdate();
	    Assert.assertNotNull(result);
	}
	
	
}
