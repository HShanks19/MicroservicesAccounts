package com.qa.consumer.service;

import org.springframework.stereotype.Service;

import org.springframework.jms.annotation.JmsListener;

@Service
public class ConsumerService {


	@JmsListener(destination = "first-queue")
	public void receiveMessage(String message) {
		try {
			Thread.sleep(10_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("RECEIVED: <" + message + ">");
	}
}


