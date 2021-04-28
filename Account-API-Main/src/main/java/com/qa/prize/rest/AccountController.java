package com.qa.prize.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.prize.domain.Account;
import com.qa.prize.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	private AccountService service;

	public AccountController(AccountService service) {
		this.service = service;
	}

	@PostMapping("/register")
	public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
		return new ResponseEntity<Account>(this.service.addAccount(account), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Account>> getAccounts() {
		return ResponseEntity.ok(this.service.getAccounts());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Account>> getAccount(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getAccount(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
		return this.service.deleteAccount(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
		return new ResponseEntity<>(this.service.updateAccount(account, id), HttpStatus.ACCEPTED);
	}
}
