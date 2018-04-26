package com.oracle.ebp_16.domain;

import org.hibernate.validator.constraints.NotBlank;

public class LoginBean {
	@NotBlank(message="�û�������Ϊ��")
	private String username;
	@NotBlank(message="���벻��Ϊ��")
	private String password;
	
	public LoginBean() {
		super();
	}
	public LoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginBean username=" + username + ", password=" + password;
	}

}
