package org.efremov.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
	public static String DEFAULT_GREETING = "Hello, GURUS!";
	
	@Override
	public String getGreeting() {
		return DEFAULT_GREETING;
	}

}
