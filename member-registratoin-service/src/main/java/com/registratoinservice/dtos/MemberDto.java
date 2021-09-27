package com.registratoinservice.dtos;

public class MemberDto {

	private long id;
	private String login;
	private String token;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", login=" + login + ", token=" + token + "]";
	}

}