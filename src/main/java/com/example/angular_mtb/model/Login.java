package com.example.angular_mtb.model;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//

public class Login {
	private boolean loginStatus;
	private User user;
	public boolean isLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Login(boolean loginStatus, User user) {
		super();
		this.loginStatus = loginStatus;
		this.user = user;
	}
	public Login() {
		super();
	}

}