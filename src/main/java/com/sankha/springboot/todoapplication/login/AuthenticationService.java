package com.sankha.springboot.todoapplication.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticateUser(String username, String password) {
		boolean isValidUsername = username.equalsIgnoreCase("sankha");
		boolean isValidPassword = password.equalsIgnoreCase("password");
		return isValidUsername && isValidPassword;
	}
}
