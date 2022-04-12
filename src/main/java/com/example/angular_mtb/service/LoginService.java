package com.example.angular_mtb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angular_mtb.controller.UserController;
import com.example.angular_mtb.model.Login;
import com.example.angular_mtb.model.User;

@Service
public class LoginService {
	@Autowired
	private UserController qcp;
	
	private Login logData = new Login();

	public Login loginWithData(String username, String password) throws Exception {
		User user = qcp.findByUserName(username);
		if (!user.getPassword().equals(password))
			throw new Exception("Login Data Invalid");
		logData.setLoginStatus(true);
		logData.setUser(user);
		return logData;
	}

	public Login logoutPresentUser() {
		if (logData.isLoginStatus()) {
			logData.setLoginStatus(false);
		}
		return logData;
	}

	public boolean loginStatus() {
		return logData.isLoginStatus();
	}
}
