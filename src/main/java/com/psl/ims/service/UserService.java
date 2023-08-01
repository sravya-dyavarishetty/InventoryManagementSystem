package com.psl.ims.service;

import java.util.List;

import com.psl.ims.entity.User;

public interface UserService {

	public User save(User user);

	List<User> getAllUsers();
	
	//public User getUserByEmail(String email);
	List<User> getUserWithUserRoleUsers();

	//public void deleteUserByUsername(String username);
	
	public void deleteUserById(String username);
}
