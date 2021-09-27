package com.registratoinservice.controllers;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registratoinservice.models.Members;
import com.registratoinservice.services.IMemberSevice;
import com.registratoinservice.services.MemberIdGenerationSeviceImpl;

@RestController
@RequestMapping("/register")
public class MemberServiceController {

	@Autowired
	private MemberIdGenerationSeviceImpl memberId;
	@Autowired
	private IMemberSevice memberService;

	@PostMapping("/register-member")
	public ResponseEntity<?> memberRegister(@RequestBody @Valid Members member, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			HashMap<String, String> errors = new HashMap<>();
			bindingResult.getFieldErrors().forEach(f -> errors.put(f.getField(), f.getDefaultMessage()));

			return new ResponseEntity<HashMap<String, String>>(errors, HttpStatus.BAD_REQUEST);
		} else {

			boolean isUserExists = memberService.isUserExistsByEmail(member.getEmail());
			if (isUserExists) {

				return new ResponseEntity<String>("Member already exists with mail", HttpStatus.CONFLICT);

			} else {
				int generateId = memberId.generateId();
				member.setId(generateId);
				member.setMemberId("R-" + generateId);
				Members save = memberService.save(member);

				if (save == null) {
					return new ResponseEntity<Members>(member, HttpStatus.NOT_FOUND);
				} else {

					return new ResponseEntity<Members>(save, HttpStatus.OK);
				}

			}

		}

	}

}
