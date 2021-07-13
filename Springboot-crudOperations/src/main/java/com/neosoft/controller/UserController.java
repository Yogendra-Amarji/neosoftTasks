package com.neosoft.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.neosoft.entities.User;
import com.neosoft.service.UserService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;


	@GetMapping("/")
	public String Welcome() {
		return "User Details.............";
	}

	
	// Register User
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
		public User registerUser(@Valid @RequestBody User user) {
		return userService.registerUser(user);
	}

	// Show All User
	@RequestMapping(value = "/showalluser", method = RequestMethod.GET)
		public List<User> showAllUser() {
		return userService.showAllUser();
	}

	// Update User
	@RequestMapping(value = "/updateuser/{id}", method = RequestMethod.PUT)
	public User updateUser(@Valid @PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	// Search By first Name
	@GetMapping("/getbyfirstname/{firstname}")
	public List<User> getUserbyfirstame(@PathVariable String firstname) { 
		return userService.getUserbyfirstame(firstname);
	}

	// Search By Last Name
	@GetMapping("/getbylastname/{lastname}")
	public List<User> searchUserbylastName(@PathVariable String lastname) {
		return userService.searchUserbylastName(lastname);
	}

	// Search By Pincode
	@GetMapping("/getbypincode/{pincode}")
	public List<User> searchUserbyPinCode(@PathVariable String pincode) {
		return userService.searchUserbyPinCode(pincode);
	}

	// Delete by Id
	@RequestMapping(value = "/deletebyid/{id}", method = RequestMethod.DELETE)
	public void deleteUserbyid(@PathVariable Long id) {
		userService.deleteUserbyid(id);
	}

	// Sorting Dob
	@GetMapping("/sortBydob")
	public List<User> sortUserbydob() {
		return userService.sortUserbydob();
	}

	// Sorting Joining Date
	@GetMapping("/sortByJoiningdate")
	public List<User> sortUserbyjoiningdate() {
		return userService.sortUserbyjoiningdate();
	}

}
