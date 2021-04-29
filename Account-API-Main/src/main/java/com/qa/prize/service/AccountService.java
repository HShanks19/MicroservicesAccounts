package com.qa.prize.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.prize.domain.Account;
import com.qa.prize.repo.AccountRepo;

@Service
public class AccountService {

	private AccountRepo repo;
	private RestTemplate rest;
	private JmsTemplate jms;

	public AccountService(AccountRepo repo, RestTemplate rest, JmsTemplate jms) {
		super();
		this.repo = repo;
		this.rest = rest;
		this.jms = jms;
	}

	public List<Account> getAccounts() {
		return repo.findAll();
	}

	public Account addAccount(Account account) {
		account.setLotteryNumber(this.rest.getForObject("http://num-gen/number/generate", String.class));
		String prize = this.rest.getForObject("http://prize-gen/prize/generate/" + account.getLotteryNumber(), String.class);
		account.setPrize(Integer. parseInt(prize));
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
	

    public void sendAccount(Long id) {
    	Account account = this.repo.findById(id).orElse(null);
    	String username = account.getUsername();
    	String prize = "" + account.getPrize();
    	String toSend = "Username: " + username + " Prize: " + prize;
        jms.convertAndSend("first-queue", toSend);
    }
    
    public void registerAccount(Account account) {
    	addAccount(account);
    	Long id = account.getId();
    	sendAccount(id);
    }

}
