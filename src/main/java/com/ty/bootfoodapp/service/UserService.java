package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.bootfoodapp.dao.UserDao;
import com.ty.bootfoodapp.dto.Login;
import com.ty.bootfoodapp.dto.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	public User saveUser(User user) {
		return userDao.saveUser(user);	
	}
	public List<User> getAllUser() {
		return userDao.getAllUser();	
	}
	public User updateUser(int userId, User user) {
		return userDao.updateUser(userId, user);	
	}
	public User getUserById(int userId)
	{
		return userDao.getUserById(userId);
	}
	public  String deleteUserById(int userId)
	{
		return userDao.deleteUserById(userId);	
	}
	public List<User> getUserByUserEmail( String userEmail)
	{
		return userDao.getUserByUserEmail(userEmail);
	}
	
	public List<User> getUserByUserPassword(String userPassword) {
		return userDao.getUserByUserPassword(userPassword);
	}
	public User validateUser(Login login)
	{
		return userDao.validateUser(login);
		
	}
}
