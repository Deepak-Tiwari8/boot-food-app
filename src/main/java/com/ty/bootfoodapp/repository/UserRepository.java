package com.ty.bootfoodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ty.bootfoodapp.dto.User;


public interface UserRepository extends JpaRepository<User, Integer>
{
	List<User> findByUserPassword(String userPassword);

	List<User> findByUserEmail(String userEmail);

	@Query("Select u from User u where u.userEmail=:myemail And u.userPassword=:mypassword")
	User Login(@Param("myemail")String userEmail,@Param("mypassword") String userPassword);

}
