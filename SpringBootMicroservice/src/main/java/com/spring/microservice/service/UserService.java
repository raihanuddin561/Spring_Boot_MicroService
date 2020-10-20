package com.spring.microservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.microservice.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
	UserDto createUser(UserDto userDto);
	UserDto getUser(String email);
	UserDto getUserById(String id);
}
