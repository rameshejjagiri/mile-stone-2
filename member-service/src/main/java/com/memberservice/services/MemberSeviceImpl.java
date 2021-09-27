package com.memberservice.services;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.memberservice.dtos.MemberDto;
import com.memberservice.models.Members;
import com.memberservice.repositories.MemberRepo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class MemberSeviceImpl implements IMemberSevice {

	@Autowired
	private MemberRepo memberRepo;
	private PasswordEncoder passwordEncoder;

	@Value("${security.jwt.token.secret-key:secret-key}")
	private String secretKey;

	@Override
	public Members save(Members member) {

		return memberRepo.save(member);
	}

	@Override
	public Members getMemberByEmail(String email) {

		return memberRepo.findByEmail(email);
	}

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	public MemberDto signIn(com.memberservice.dtos.CredentialsDto credentialsDto) {
		Members member = memberRepo.findByEmail(credentialsDto.getLogin());
		MemberDto memberDto = new MemberDto();
		System.out.println(member);

		if (credentialsDto.getPassword().equals(member.getPassword())) {
			memberDto.setId(member.getId());
			memberDto.setLogin(member.getEmail());
			memberDto.setToken(createToken(member));
		}
		return memberDto;

	}

	public MemberDto validateToken(String token) {

		String email = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
		Members member = memberRepo.findByEmail(email);
		System.err.println("Validating Token");
		String createToken = createToken(member);
		System.err.println(createToken);
		MemberDto memberDto = new MemberDto();
		memberDto.setId(member.getId());
		memberDto.setLogin(member.getEmail());
		memberDto.setToken(createToken);

		return memberDto;
	}

	private String createToken(Members user) {
		System.out.println(user);
		Claims claims = Jwts.claims().setSubject(user.getEmail());
		Date now = new Date();
		Date validity = new Date(now.getTime() + 3600000); // 1 hour

		return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity)
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}

	@Override
	public Members updateMemberDetails(Members member) {

		return memberRepo.save(member);
	}

}
