package com.spring.microservice.utility;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class Utils {
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	
	public String generateUserId(int length) {
		return generateRandomKey(length);
	}
	
	public String generateRandomKey(int length) {
		StringBuilder random = new StringBuilder(length);
		for(int i=0;i<length;i++) {
			random.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		
		return new String(random);
	}
	
}
