 package com.example.page.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.page.model.User;
import com.example.page.model.UserDto;
import com.example.page.repository.UserRepository;

@Service
public class UserServiceImpl 
{
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public User save(UserDto userDto) {
	    if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
	        throw new IllegalArgumentException("Passwords do not match.");
	       
	    }

	    User user = new User();
	    user.setEmail(userDto.getEmail());
	    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
	    user.setRole("USER");
	    user.setName(userDto.getName());
	    user.setTechnology(userDto.getTechnology());
	    user.setTrainer(userDto.getTrainer());
	    
	    return userRepository.save(user);
	}


	public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
