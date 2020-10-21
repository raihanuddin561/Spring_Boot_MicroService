package com.spring.microservice.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservice.model.request.UserDetailsRequestModel;
import com.spring.microservice.model.response.ErrorMessages;
import com.spring.microservice.model.response.UserRest;
import com.spring.microservice.service.UserService;
import com.spring.microservice.shared.dto.UserDto;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping(path="/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public UserRest getUser(@PathVariable String id) {
		UserRest returnValue= new UserRest();
		UserDto dto = userService.getUserById(id);
		if(dto==null) {
			throw new RuntimeException("user not found");
		}
		BeanUtils.copyProperties(dto, returnValue);
		return returnValue;
	}
	
	
	@PostMapping(
			consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception {
		if(userDetails.getFirstName().equals("")) throw new Exception(ErrorMessages.Missing_Requered_Field_Error.getErrorMessage());
		UserRest returnValue = new UserRest();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}
}
