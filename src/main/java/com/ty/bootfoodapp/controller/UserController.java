package com.ty.bootfoodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bootfoodapp.dto.Login;
import com.ty.bootfoodapp.dto.User;
import com.ty.bootfoodapp.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public String saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return "User Saved";
	}

	@GetMapping("/users")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@PutMapping("/users/{userId}")
	public User updateUser(@PathVariable int userId, @RequestBody User user) {
		return userService.updateUser(userId, user);
	}

	@GetMapping("/users{userId}")
	public User getUserById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}

	@DeleteMapping("/users{userId}")
	public String deleteUserById(int userId) {
		return userService.deleteUserById(userId);
	}

	@GetMapping("/userEmail")
	public List<User> getUserByEmail(@RequestParam String userEmail) {
		return userService.getUserByUserEmail(userEmail);
	}

	@GetMapping("/userPassword")
	public List<User> getUserByUserPassword(@RequestParam String userPassword) {
		return userService.getUserByUserPassword(userPassword);
	}

	@PostMapping("/users/login")
	public User validateUser(@RequestParam Login login) {
		return userService.validateUser(login);
	}

}
