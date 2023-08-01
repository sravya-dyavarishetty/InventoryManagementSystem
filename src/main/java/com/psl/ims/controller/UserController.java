package com.psl.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.psl.ims.entity.User;
import com.psl.ims.service.UserService;

import javassist.expr.NewArray;

@Controller
public class UserController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	UserService userService;
	
	
	//handler for custom login
	@GetMapping("/signin")
	public String customLogin()
	{
		return "login";
	}
	
	//to show registration form
	 @GetMapping("/registration") public String showRegistrationForm(Model model)
	  { 
//sending empty object to the registration form to hold the user object details
	   model.addAttribute("user", new User()); 
	   return "registration_form"; 
	   }
	 
	
	//once clicked on register button,this handler will be called
	
	@PostMapping("/process_register")
	public String registerUserAccount(@ModelAttribute("user") User user)
	{
		user.setRole("ROLE_USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);
		
		return "redirect:/signin";
		
	}
	
	//list all users
	
	
	
	
	
	
}
