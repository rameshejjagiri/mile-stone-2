package com.claimservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claimservice.models.MemberClaims;
import com.claimservice.services.MemberClaimService;

@RestController
@RequestMapping("/api/claim")
public class MemberClaimController {

	@Autowired
	private MemberClaimService memberClaimService;

	@RequestMapping("/get-claims")
	public List<MemberClaims> getAllMembers() {
		return memberClaimService.pugetClaims();
	}

	@RequestMapping("/save-claim")
	public MemberClaims saveClaim(@RequestBody MemberClaims memberClaims) {
		/*
		 * MemberClaims memberClaims = new MemberClaims(); memberClaims.setId(1515454);
		 * memberClaims.setName("Ejjagiri");
		 */
		return memberClaimService.saveClaim(memberClaims);
	}

}
