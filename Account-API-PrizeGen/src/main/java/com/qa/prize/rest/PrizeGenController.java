package com.qa.prize.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.prize.service.PrizeGenService;

@RestController
@RequestMapping("/prize")
public class PrizeGenController {

	private PrizeGenService service;

	public PrizeGenController(PrizeGenService service) {
		super();
		this.service = service;
	}

	@GetMapping("/generate/{generatedString}")
	public ResponseEntity<String> getPrize(@PathVariable String generatedString) {
		return ResponseEntity.ok(this.service.returnPrize(generatedString));
	}
}
