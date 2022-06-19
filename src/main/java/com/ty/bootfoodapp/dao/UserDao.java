package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.dto.Login;
import com.ty.bootfoodapp.dto.User;
import com.ty.bootfoodapp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User updateUser(int userId, User user) {
		Optional<User> opt = userRepository.findById(userId);
		if (opt.isEmpty()) {
			return null;
		} else {
			return userRepository.save(user);
		}
	}

	public User getUserById(int userId) {

		Optional<User> opt = userRepository.findById(userId);
		if (opt.isEmpty()) {
			return null;
		} else {
			return opt.get();
		}
	}

	public String deleteUserById(int userId) {
		Optional<User> opt = userRepository.findById(userId);
		if (opt.isEmpty()) {
			return "No User to deleted";
		} else {
			User user = opt.get();
			userRepository.delete(user);
			return "User deleted";
		}
	}

	public List<User> getUserByUserEmail(String userEmail) {
		return userRepository.findByUserEmail(userEmail);
	}

	public List<User> getUserByUserPassword(String userPassword) {
		return userRepository.findByUserPassword(userPassword);
	}
	
	public User validateUser(Login login)
	{
		return userRepository.Login(login.getUserEmail(),login.getUserPassword());
	}

}
