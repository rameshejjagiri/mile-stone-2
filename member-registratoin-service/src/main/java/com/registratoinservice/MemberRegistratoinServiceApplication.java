package com.registratoinservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MemberRegistratoinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberRegistratoinServiceApplication.class, args);
	}

}
