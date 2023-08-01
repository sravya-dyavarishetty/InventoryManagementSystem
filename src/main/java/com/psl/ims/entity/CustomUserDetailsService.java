package com.psl.ims.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.psl.ims.repository.UserRepository;

@Service
public class CustomUserDetailsService  implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepository.getUserByUserName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("NO SUCH USER FOUND");
		}
		return new CustomUserDetails(user);
	}

	
}
