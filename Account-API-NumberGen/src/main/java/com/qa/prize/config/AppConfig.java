package com.qa.prize.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qa.prize.util.NumberGenerator;

@Configuration
public class AppConfig {

	@Bean
	public NumberGenerator numberGenerator() {
		return new NumberGenerator(6);
	}
}
