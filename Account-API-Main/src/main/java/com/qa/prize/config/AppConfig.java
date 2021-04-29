package com.qa.prize.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@LoadBalanced // load balances the rest template and enables name resolution
	@Bean // telling Spring to make this for me
	public RestTemplate loadBalancedRestTemplate() {
		return new RestTemplate();
	}
}
