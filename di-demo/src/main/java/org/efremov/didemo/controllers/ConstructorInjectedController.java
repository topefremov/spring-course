package org.efremov.didemo.controllers;

import org.efremov.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {
	private GreetingService greetingService;

	@Autowired
	public ConstructorInjectedController(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}

	public String sayHello() {
		return greetingService.getGreeting();
	}
}
