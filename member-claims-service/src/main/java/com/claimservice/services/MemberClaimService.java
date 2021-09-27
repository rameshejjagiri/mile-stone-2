package com.claimservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claimservice.repositories.MemberClaimsRepo;
import com.netflix.discovery.converters.Auto;
import com.claimservice.models.MemberClaims;

@Service
public class MemberClaimService {
	@Autowired
	private MemberClaimsRepo memberClaimRepo;
	@Autowired
	private ClamIdGenerationSevice claimIdGen;

	public List<MemberClaims> getClaims() {

		return memberClaimRepo.findAll();
	}

	public MemberClaims saveClaim(MemberClaims memberClaim) {
		int generateMemberId = claimIdGen.generateMemberId();
		memberClaim.setId(generateMemberId);
		return memberClaimRepo.save(memberClaim);
	}

	public List<MemberClaims> getClaimsByMemberId(String memberId) {
		
		return memberClaimRepo.findByMemberId(memberId);
	}

	

}
