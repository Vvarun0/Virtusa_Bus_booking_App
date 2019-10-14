package com.virtusa.travelline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.travelline.models.User;
import com.virtusa.travelline.services.RoleService;
import com.virtusa.travelline.services.UserService;
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@RequestMapping(value="/login")
	public  String login(@ModelAttribute User user,Model model)
	{
		System.out.println(user.getEmail()+","+user.getPassword());
		User user1=userService.getUserById(user.getEmail());
		
		model.addAttribute("user",user1);
		/*
		 * if(roleService.getUserRoleById("ROLE_ADMIN").getUser().getEmail().
		 * equalsIgnoreCase(user.getEmail())) { return "adminhome"; } else return
		 * "hello";
		 */
		return "redirect:/";
	}
	
	/*
	 * @RequestMapping(value="/loginaction") public String loginAction() { return
	 * "hello"; }
	 */
	
	/*
	 * @PostMapping("/loginaction") public String loginA() { return "hello"; }
	 * 
	 * @GetMapping("/loginaction") public String oginAction() { return "hello"; }
	 */
	@GetMapping("/error") 
	  public String error(Model model) { 
		  model.addAttribute("loginError", true);
		  return "error"; 
		  }
}
