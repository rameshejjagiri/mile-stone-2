package com.loginservice.dtos;

public class CredentialsDto {
	private String userName;
	private String password;

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CredentialsDto(String username, String password) {
		super();
		this.userName = username;
		this.password = password;
	}

	public CredentialsDto() {

	}

	@Override
	public String toString() {
		return "CredentialsDto [userName=" + userName + ", password=" + password + "]";
	}

}
