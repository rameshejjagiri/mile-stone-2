package com.claimservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claimservice.repositories.MemberClaimsRepo;
import com.claimservice.models.MemberClaims;

@Service
public class MemberClaimService {
	@Autowired
	private MemberClaimsRepo memberClaimRepo;

	public List<MemberClaims> pugetClaims() {

		return memberClaimRepo.findAll();
	}

	public MemberClaims saveClaim(MemberClaims memberClaims) {
		// TODO Auto-generated method stub
		return memberClaimRepo.save(memberClaims);
	}

}
