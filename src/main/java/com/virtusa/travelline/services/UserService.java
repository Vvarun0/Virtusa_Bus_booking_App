package com.virtusa.travelline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.travelline.models.User;
import com.virtusa.travelline.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	public User getUserById(String emailId)
	{
		return userRepository.findById(emailId).orElse(null);
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public boolean deleteUser(String userId) 
	{
		boolean status = false;
		try {
			userRepository.deleteById(userId);
			status = true;
		} 
		catch (Exception e) {
		}
		return status;
	}
}