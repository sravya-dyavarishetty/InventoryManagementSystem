package com.psl.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psl.ims.service.UserService;

@Controller
@RequestMapping("/users")
public class ListUserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String listAllUsers(Model model )
	{
		//model.addAttribute("users",userService.getAllUsers() );
	
		model.addAttribute("users",userService.getUserWithUserRoleUsers());
		return "list_users";
	}
	
	@GetMapping("/{username}")
	public String deleteUser(@PathVariable String username) {
		//productService.deleteStudentById(id);
		userService.deleteUserById(username);	
		return "redirect:/users/";
	}
}
