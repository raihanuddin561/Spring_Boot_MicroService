package com.spring.microservice.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservice.model.request.UserDetailsRequestModel;
import com.spring.microservice.model.response.UserRest;
import com.spring.microservice.service.UserService;
import com.spring.microservice.shared.dto.UserDto;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping(path="/{id}")
	public UserRest getUser(@PathVariable String id) {
		UserRest returnValue= new UserRest();
		UserDto dto = userService.getUserById(id);
		if(dto==null) {
			throw new RuntimeException("user not found");
		}
		BeanUtils.copyProperties(dto, returnValue);
		return returnValue;
	}
	
	
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest returnValue = new UserRest();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}
}
