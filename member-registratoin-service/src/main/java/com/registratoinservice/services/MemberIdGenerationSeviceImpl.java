package com.registratoinservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registratoinservice.models.Members;
import com.registratoinservice.repositories.MemberRepo;

@Service
public class MemberIdGenerationSeviceImpl {

	@Autowired
	private MemberRepo memberRepo;

	public int generateId() {
		int memberId = 0;
		int generatedId = getRandomId();
		Optional<Members> findByMemberId = memberRepo.findById(generatedId);
		System.out.println("Member by id " + findByMemberId);
		if (findByMemberId.isPresent()) {
			generateId();
		} else {
			memberId = generatedId;
		}
		return memberId;
	}

	int getRandomId() {
		int randomPIN = (int) (Math.random() * 900) + 100;
		return randomPIN;
	}

}
