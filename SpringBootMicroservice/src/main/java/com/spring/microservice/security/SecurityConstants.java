package com.spring.microservice.security;

import com.spring.microservice.SpringApplicationContext;

public class SecurityConstants {
	public static final Long EXPIRATION_TIME = 864000000L;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String SINGUP_URL = "/user";
	public static final String HEADER_STRING = "Authorization";
	//public static final String TOKEN_SECRET ="alakarpula";
	
	public static String getToken() {
		AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("appProperties");
		return appProperties.getSecretToken();
	}
}
