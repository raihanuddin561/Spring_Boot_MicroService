package com.spring.microservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.microservice.entity.UserEntity;
import com.spring.microservice.repository.UserRepository;
import com.spring.microservice.service.UserService;
import com.spring.microservice.shared.dto.UserDto;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDto createUser(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userEntity.setUserId("testId");
		userEntity.setEncryptedPassword("test");
		UserEntity userDetails=userRepository.save(userEntity);
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userDetails, returnValue);
		
		return returnValue;
	}

}
