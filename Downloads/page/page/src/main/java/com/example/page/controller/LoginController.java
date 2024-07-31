package com.example.page.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.page.model.UserDto;
import com.example.page.service.UserService;
import com.example.page.service.UserServiceImpl;

import jakarta.validation.Valid;

@Controller
public class LoginController {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserServiceImpl userServiceimpl;
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	 @GetMapping("/")
	    public String Home() {
	    	 return "home"; 
	    }

	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult, Model model) {
	    // Check if the email is already registered
	    if (userServiceimpl.existsByEmail(userDto.getEmail())) {
	        model.addAttribute("message", "There is already an account registered with that email.");
	    } else if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
	        model.addAttribute("message", "Password and confirm password should be same");
	    } else {
	        userService.save(userDto);
	        model.addAttribute("message", "Registered Successfully!");
	    }

	    return "register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "user";
	}
	
	@GetMapping("admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin";
	}

}

