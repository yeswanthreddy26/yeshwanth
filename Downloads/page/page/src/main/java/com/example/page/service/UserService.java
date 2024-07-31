package com.example.page.service;

import org.springframework.stereotype.Service;

import com.example.page.model.User;
import com.example.page.model.UserDto;


@Service
public interface UserService 
{
	
User save (UserDto userDto);
	
    boolean existsByEmail(String email);
	

}
