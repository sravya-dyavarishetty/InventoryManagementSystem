package com.psl.ims.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.psl.ims.entity.User;


public interface UserRepository extends JpaRepository<User, String>{

	@Query("select u from User u where u.username =  :username")
	public User getUserByUserName(@Param("username") String username);
	
	@Query(value ="select * from user where role=\"ROLE_USER\"",nativeQuery = true)
	public List<User> getUsersWithUserRole();
	
	
	
	
	

	/*
	 * @Query("delete from User where username = :username") void
	 * deleteByUsername(@Param("username") String username);
	 */
	
	
	
}
