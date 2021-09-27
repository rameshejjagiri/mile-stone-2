package com.registratoinservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registratoinservice.models.Members;
import com.registratoinservice.repositories.MemberRepo;

@Service
public class MemberSeviceImpl implements IMemberSevice {

	@Autowired
	private MemberRepo memberRepo;

	@Override
	public Members save(Members member) {

		return memberRepo.save(member);
	}

	@Override
	public boolean isUserExistsByEmail(String email) {
		Members findByEmail = memberRepo.findByEmail(email);
		return findByEmail == null ? false : true;
	}

}
