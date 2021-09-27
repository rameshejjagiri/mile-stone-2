package com.loginservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginservice.dtos.CredentialsDto;
import com.loginservice.dtos.MemberDto;
import com.loginservice.services.IMemberSevice;

@RestController
@RequestMapping("/login")
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IMemberSevice memberService;

	@PostMapping("/member-login")
	public ResponseEntity<?> memberLogin(@RequestBody CredentialsDto credentials) {

		logger.info(credentials.toString());
		MemberDto signIn = memberService.signIn(credentials);
		if (signIn == null) {
			return new ResponseEntity<String>("Login failed", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<MemberDto>(signIn, HttpStatus.OK);
		}

	}

}
