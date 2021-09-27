package com.claimservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.claimservice.repositories", "com.claimservice.controllers",
		"com.claimservice.services" })
public class MemberClaimServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberClaimServiceApplication.class, args);
	}

}
