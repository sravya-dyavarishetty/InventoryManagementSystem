package com.psl.ims.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.ims.entity.Product;
import com.psl.ims.entity.User;
import com.psl.ims.repository.UserRepository;
import com.psl.ims.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	

//	@Override
//	public User getUserByEmail(String email) {
//		return userRepository.findByEmail(email);
//	}
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}



	@Override
	public List<User> getUserWithUserRoleUsers() {
		return userRepository.getUsersWithUserRole();
	}
	/*
	 * @Override public void deleteUserByUsername(String username) { // TODO
	 * Auto-generated method stub userRepository.deleteByUsername(username); }
	 */



	@Override
	public void deleteUserById(String username) {
		// TODO Auto-generated method stub
	 userRepository.deleteById(username);
	}

	
}
