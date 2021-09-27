package com.memberservice.services;

import com.memberservice.dtos.CredentialsDto;
import com.memberservice.dtos.MemberDto;
import com.memberservice.models.Members;

public interface IMemberSevice {

	Members save(Members member);

	Members getMemberByEmail(String email);

	MemberDto validateToken(String token);

	MemberDto signIn(CredentialsDto credentialsDto);

	Members updateMemberDetails(Members member);

}
