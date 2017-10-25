package com.moreti.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean isUserValid(String user, String password) {
		if (user.equals("Kleber") && password.equals("1234")) {
			return true;
		}
		return false;
	}
}
