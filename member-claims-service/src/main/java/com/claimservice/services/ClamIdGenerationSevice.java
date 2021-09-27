package com.claimservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claimservice.models.MemberClaims;
import com.claimservice.repositories.MemberClaimsRepo;
@Service
public class ClamIdGenerationSevice {

	@Autowired
	private MemberClaimsRepo memberClaimRepo;

	public int generateMemberId() {
		int claimID = 0;
		int genertedValue = getRandomId();
		Optional<MemberClaims> findById = memberClaimRepo.findById(genertedValue);
		if (findById.isPresent()) {
			generateMemberId();
		} else {
			claimID = genertedValue;
		}

		return claimID;
	}

	int getRandomId() {
		int randomPIN = (int) (Math.random() * 9000) + 1000;
		return randomPIN;
	}

}
