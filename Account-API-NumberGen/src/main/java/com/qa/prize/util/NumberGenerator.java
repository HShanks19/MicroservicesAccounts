package com.qa.prize.util;

import java.util.Random;


public class NumberGenerator {

	public NumberGenerator(int i) {
		// TODO Auto-generated constructor stub
	}

	String chars = "abc";
	
	Random rnd = new Random();
		
	public String genNumber() {
		String lottery = generateChar() + generateNum();
		return lottery;
	}
	
	public char generateChar () {
		char c = chars.charAt(rnd.nextInt(chars.length()));
		return c;
		
	}
	
	public String generateNum() {
		Random randnum = new Random();
	      int upperbound = 3;
	      int int_random = randnum.nextInt(upperbound);
		if (int_random == 0) {
			return getRandomNumberStringSix();
		} else if (int_random == 1) {
			return getRandomNumberStringEight();
		} else if (int_random == 2) {
			return getRandomNumberStringTen();
		} 
		return "null";
		
	}

	public String getRandomNumberStringSix() {
	    Random sixrnd = new Random();
	    int number = 100000 + sixrnd.nextInt(899999);
	    return String.format("%06d", number);
	}
	
	public String getRandomNumberStringEight() {
	    Random eightrnd = new Random();
	    int number = 10000000 + eightrnd.nextInt(89999999);
	    return String.format("%06d", number);
	}
	
	public String getRandomNumberStringTen() {
		Random random=new Random();
	    int randomNumber=0;
	    boolean loop=true;
	    while(loop) {
	        randomNumber=random.nextInt();
	        if(Integer.toString(randomNumber).length()==10 && !Integer.toString(randomNumber).startsWith("-")) {
	            loop=false;
	        }
	        }
	    return String.format("%06d", randomNumber);
	}
}
