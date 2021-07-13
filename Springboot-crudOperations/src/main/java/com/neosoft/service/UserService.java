package com.neosoft.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.neosoft.entities.User;
import com.neosoft.exception.UserNotFoundException;
import com.neosoft.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional      // Register new user
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	// Get all
	public List<User> showAllUser() {
		return userRepository.findAll();
	}

	// Update Custom Exception
	public User updateUser(Long id, User user) {
		User userupdate = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User Not Found...with id: " + id));

		userupdate.setFirstname(user.getFirstname());
		userupdate.setLastname(user.getLastname());
		userupdate.setEmail(user.getEmail());
		userupdate.setPincode(user.getPincode());
		userupdate.setPhno(user.getPhno());
		userupdate.setStatus(user.getStatus());
		userupdate.setDob(user.getDob());
		userupdate.setJoiningdate(user.getJoiningdate());
		return userRepository.save(userupdate);
	}

	// search by Firstname
	public List<User> getUserbyfirstame(String firstname) {
		return userRepository.findByFirstname(firstname);
	}

	// search by lastname
	public List<User> searchUserbylastName(String lastname) {
		return userRepository.findByLastname(lastname);
	}

	// search by Pincode
	public List<User> searchUserbyPinCode(String pincode) {
		return userRepository.findByPincode(pincode);
	}
	
	//delete
	public void deleteUserbyid(Long id) {
		 userRepository.deleteById(id);
	}

	// Sort by dob
	public List<User> sortUserbydob() {
		return userRepository.findByOrderByDobAsc();
	}

	// Sort by Joining Date
	public List<User> sortUserbyjoiningdate() {
		return userRepository.findAllByOrderByJoiningdateAsc();
	}

	
	
	
}
