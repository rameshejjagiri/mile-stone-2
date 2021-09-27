package com.claimservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = { "com.claimservice.repositories", "com.claimservice.controllers",
		"com.claimservice.services" })
@EnableEurekaClient
public class MemberClaimServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberClaimServiceApplication.class, args);
	}

}
