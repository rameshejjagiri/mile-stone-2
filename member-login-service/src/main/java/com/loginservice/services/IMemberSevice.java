package com.loginservice.services;

import com.loginservice.dtos.CredentialsDto;
import com.loginservice.dtos.MemberDto;

public interface IMemberSevice {
	MemberDto signIn(CredentialsDto credentialsDto);

}
