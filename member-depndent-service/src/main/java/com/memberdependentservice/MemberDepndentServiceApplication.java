package com.memberdependentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MemberDepndentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberDepndentServiceApplication.class, args);
	}

}
