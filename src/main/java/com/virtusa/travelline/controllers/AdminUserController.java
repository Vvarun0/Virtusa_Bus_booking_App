package com.virtusa.travelline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtusa.travelline.Encrypt;
import com.virtusa.travelline.models.Feedback;
import com.virtusa.travelline.models.Role;
import com.virtusa.travelline.models.User;
import com.virtusa.travelline.services.FeedbackService;
import com.virtusa.travelline.services.RoleService;
import com.virtusa.travelline.services.UserService;

@Controller
public class AdminUserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private FeedbackService feedbackService;
	

	@PostMapping(value="/viewgivenfeedback")
	public  String viewFeedback(@ModelAttribute Feedback feedback,Model model)
	{
		feedbackService.getAllFeedback();
		return "viewfeedback";//user delete operations (delete) button in the admin home page
	}
	
	@PostMapping("/addnewadmin")
	public String addAdmin(@ModelAttribute User user,@ModelAttribute Role role,Model model)
	{
		user.setPassword(new Encrypt().encrypt((user.getPassword())));
		System.out.println(user.getEmail());
		userService.addUser(user);
		System.out.println(user.getUserName());
		role.setRoleName("ROLE_ADMIN");
		role.setUser(user);
		model.addAttribute("message", "admin added successfully");
		roleService.addUserRole(role);
		return "addadmin";
	}
}