package com.loginservice.dtos;

public class MemberDto {

	private String memberId;
	private String email;
	private String token;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", email=" + email + ", token=" + token + "]";
	}

}