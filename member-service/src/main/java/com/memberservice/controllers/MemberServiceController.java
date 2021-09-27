package com.memberservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memberservice.dtos.MemberDto;
import com.memberservice.models.Members;
import com.memberservice.services.IMemberSevice;

@RestController
@RequestMapping("/member")
public class MemberServiceController {

	@Autowired
	private IMemberSevice memberService;

	@PutMapping("/update-member-details")
	public ResponseEntity<?> memberUpdate(@RequestBody Members member) {

		member = memberService.updateMemberDetails(member);

		if (member == null) {
			return new ResponseEntity<Members>(member, HttpStatus.NOT_ACCEPTABLE);
		} else {

			return new ResponseEntity<Members>(member, HttpStatus.OK);
		}
	}

	@GetMapping("/get-details-by-mail/{email}")
	public ResponseEntity<?> getMemberDetails(@PathVariable String email) {
		System.out.println(email);
		Members member = memberService.getMemberByEmail(email);
		System.out.println(member);

		return new ResponseEntity<Members>(member, HttpStatus.OK);

	}

	@PostMapping("/validateToken")
	public ResponseEntity<?> validateToken(@RequestParam String token) {

		// MemberDto signIn = memberService.signIn(new
		// CredentialsDto("ramesh@gmail.com", "Rnbd@334"));

		System.err.println("Validating the token");

		// System.out.println("Token " + token);
		// Members member = memberService.getMemberByEmail(token);

		// System.out.println(member);

		return new ResponseEntity<MemberDto>(memberService.validateToken(token), HttpStatus.OK);

	}

}
