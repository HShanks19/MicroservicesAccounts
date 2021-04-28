package com.qa.prize.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.prize.service.AccountNumGenService;

@RestController
@RequestMapping("/number")
public class NumberGenController {

	private AccountNumGenService service;

	public NumberGenController(AccountNumGenService service) {
		this.service = service;
	}

	@GetMapping("/generate")
	public ResponseEntity<String> generateNumber() {
		return this.service.genNumber();
	}


}
