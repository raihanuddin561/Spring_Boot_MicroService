package com.spring.microservice.service;

import com.spring.microservice.shared.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);
}
