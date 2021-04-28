package com.qa.prize.service;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.prize.domain.Account;
import com.qa.prize.repo.AccountRepo;

@Service
public class AccountService {

	private AccountRepo repo;
	private RestTemplate rest;
	
	public AccountService(RestTemplateBuilder builder, AccountRepo repo) {
		super();
		this.rest = builder.build();
		this.repo = repo;
	}

	public List<Account> getAccounts() {
		return repo.findAll();
	}

	public Account addAccount(Account account) {
		account.setLotteryNumber(this.rest.getForObject("http://localhost:8001/number/generate", String.class));
		account.setPrize(this.rest.getForObject("http://localhost:8002/prize/generate/" + account.getLotteryNumber(), int.class));
		return this.repo.save(account);
	}

	public Optional<Account> getAccount(Long id) {
		Optional<Account> found = repo.findById(id);
		return found;
	}

	public boolean deleteAccount(Long id) {
		repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	public Account updateAccount(Account account, Long id) {
		Account toUpdate = this.repo.findById(id).orElse(null);
		toUpdate.setUsername(account.getUsername());
		toUpdate.setPassword(account.getPassword());
		return repo.save(toUpdate);
	}

}
