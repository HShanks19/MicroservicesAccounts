package com.qa.prize.service;

import org.springframework.stereotype.Service;

@Service
public class PrizeGenService {
	
	public int returnPrize(String generatedString) {
		int Prize = 0;
		if (generatedString.startsWith("a")) {
			Prize = 0;
		} else if (generatedString.startsWith("b")) {
			if (generatedString.length() == 7) {
				Prize = 50;
			} else if (generatedString.length() == 9) {
				Prize = 500;
			} else if (generatedString.length() == 11) {
				Prize = 5000;
			}
		} else if (generatedString.startsWith("c")) {
			if (generatedString.length() == 7) {
				Prize = 100;
			} else if (generatedString.length() == 9) {
				Prize = 750;
			} else if (generatedString.length() == 11) {
				Prize = 10000;
			}
		}
		return Prize;
	}
}
