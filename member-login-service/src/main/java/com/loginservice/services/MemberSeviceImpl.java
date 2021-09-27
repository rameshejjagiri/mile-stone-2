package com.loginservice.services;

import java.util.Base64;
import java.util.Date;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.loginservice.dtos.CredentialsDto;
import com.loginservice.dtos.MemberDto;
import com.loginservice.exceptions.AppException;
import com.loginservice.models.Members;
import com.loginservice.repositories.MemberRepo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class MemberSeviceImpl implements IMemberSevice {

	Logger logger = LoggerFactory.getLogger(MemberSeviceImpl.class);

	@Autowired
	private MemberRepo memberRepo;

	@Value("${security.jwt.token.secret-key:secret-key}")
	private String secretKey;

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	@Override
	public MemberDto signIn(CredentialsDto credentialsDto) {
		MemberDto memberDto = null;
		logger.info("Validating the credentials");
		Optional<Members> findByEmail = memberRepo.findByEmail(credentialsDto.getUsername());
		if (findByEmail.isPresent()) {
			logger.info("User Exists");
			Members member = findByEmail.get();
			if (credentialsDto.getPassword().equals(member.getPassword())) {
				memberDto=new MemberDto();
				memberDto.setMemberId(member.getMemberId());
				memberDto.setEmail(member.getEmail());
				memberDto.setToken(createToken(member));
				logger.info("User Validation succesful");
			}
		} else {
			logger.info("User not found");
			throw new AppException("User not found", HttpStatus.NOT_FOUND);
		}
		return memberDto;
	}

	public MemberDto validateToken(String token) {
		logger.info("Validating the token");
		String email = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
		Members member = memberRepo.findByEmail(email)
				.orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
		System.err.println("Validating Token");
		String createToken = createToken(member);
		System.err.println(createToken);
		MemberDto memberDto = new MemberDto();
		memberDto.setMemberId(member.getMemberId());
		memberDto.setEmail(member.getEmail());
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

}
