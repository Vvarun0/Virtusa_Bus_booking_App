package com.virtusa.travelline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtusa.travelline.Encrypt;
import com.virtusa.travelline.models.Role;
import com.virtusa.travelline.models.User;
import com.virtusa.travelline.services.RoleService;
import com.virtusa.travelline.services.UserService;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	
	@GetMapping("/registration")
	public String addNewUser()
	{
		return "registration";
	}
	@PostMapping("/register")
	public String saveCategory(@ModelAttribute User user,Model model)
	{
		user.setPassword(new Encrypt().encrypt((user.getPassword())));
		model.addAttribute("user"+userService.addUser(user));
		Role role=new Role();
		role.setRoleName("ROLE_USER");
		//role.setRoleId(3);
		role.setUser(user);
		roleService.addUserRole(role);
		model.addAttribute("user",user);
		System.out.println("user email ="+user.getEmail());
		return "login";
	}

}
