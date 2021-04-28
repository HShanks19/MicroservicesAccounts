package com.qa.prize.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	public Account() {
		super();
	}
	
	public Account( String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Account( String username, String password, String lotteryNumber, int prize) {
		super();
		this.username = username;
		this.password = password;
		this.lotteryNumber = lotteryNumber;
		this.prize = prize;
	}
	
	public Account( Long id, String username, String password, String lotteryNumber, int prize) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.lotteryNumber = lotteryNumber;
		this.prize = prize;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	private String password;
	
	private String lotteryNumber;
	
	private int prize;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLotteryNumber() {
		return lotteryNumber;
	}

	public void setLotteryNumber(String lotteryNumber) {
		this.lotteryNumber = lotteryNumber;
	}
	
	public int getPrize() {
		return prize;
	}

	public void setPrize(int x) {
		this.prize = x;
	}


}
