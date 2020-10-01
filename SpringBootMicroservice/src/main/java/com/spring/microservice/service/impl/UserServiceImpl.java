package com.spring.microservice.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.microservice.entity.UserEntity;
import com.spring.microservice.repository.UserRepository;
import com.spring.microservice.service.UserService;
import com.spring.microservice.shared.dto.UserDto;
import com.spring.microservice.utility.Utils;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	Utils utils;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public UserDto createUser(UserDto userDto) {
		if(userRepository.findByEmail(userDto.getEmail())!=null) throw new RuntimeException("User already exists");
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userEntity.setUserId(utils.generateUserId(30));
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		UserEntity userDetails=userRepository.save(userEntity);
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userDetails, returnValue);
		
		return returnValue;
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity=userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	}
	@Override
	public UserDto getUser(String email) {
		UserEntity userEntity=userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

}
