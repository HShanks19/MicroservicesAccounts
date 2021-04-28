package com.qa.prize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountApiMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApiMainApplication.class, args);
	}

}
