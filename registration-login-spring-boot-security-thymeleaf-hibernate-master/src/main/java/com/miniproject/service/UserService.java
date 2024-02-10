package com.miniproject.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.miniproject.dto.UserRegistrationDto;
import com.miniproject.model.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
