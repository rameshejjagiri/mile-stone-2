package com.claimservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claimservice.models.MemberClaims;
import com.claimservice.services.MemberClaimService;

@RestController
@RequestMapping("/claim")
public class MemberClaimController {

	@Autowired
	private MemberClaimService memberClaimService;

	@RequestMapping("/get-claims")
	public List<MemberClaims> getAllMembers() {
		List<MemberClaims> pugetClaims = memberClaimService.getClaims();
		return pugetClaims;
	}

	@PostMapping("/submit-claim")
	public MemberClaims saveClaim(@RequestBody MemberClaims memberClaims) {
		return memberClaimService.saveClaim(memberClaims);
	}

	@RequestMapping("/get-claims-by-member-id/{memberId}")
	public List<MemberClaims> getClaimsByMemberId(@PathVariable String memberId) {
		return memberClaimService.getClaimsByMemberId(memberId);
	}

}
