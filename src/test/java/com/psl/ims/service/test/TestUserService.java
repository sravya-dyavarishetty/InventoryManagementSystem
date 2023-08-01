package com.psl.ims.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.psl.ims.entity.User;
import com.psl.ims.repository.UserRepository;

import com.psl.ims.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {

	
	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void TestSaveUser()
	{
		User user=new User();
		user.setEmail("abc@gmail.com");
		user.setPassword("xyz");
		user.setRole("ROLE_ADMIN");
		user.setUsername("abc123");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertThat(userService.save(user)).isEqualTo(user);
	}
	@Test
	public void TestGetAllUsers()
	{
		User user=new User();
		user.setEmail("abc@gmail.com");
		user.setPassword("xyz");
		user.setRole("ROLE_ADMIN");
		user.setUsername("abc123");
		
		User user2=new User();
		user2.setEmail("h@gmail.com");
		user2.setPassword("h1908");
		user2.setRole("ROLE_USER");
		user2.setUsername("h123");
		
		ArrayList<User> userlist=new ArrayList<User>();
		userlist.add(user2);
		userlist.add(user);
		Mockito.when(userRepository.findAll()).thenReturn(userlist);
		assertThat(userService.getAllUsers()).isEqualTo(userlist);
		assertEquals(2, userService.getAllUsers().size());
		
	}
	
	/*
	 * @Test public void TestDeleteUserById() { User user=new User();
	 * user.setEmail("abc@gmail.com"); user.setPassword("xyz");
	 * user.setRole("ROLE_ADMIN"); user.setUsername("abc123");
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
}
