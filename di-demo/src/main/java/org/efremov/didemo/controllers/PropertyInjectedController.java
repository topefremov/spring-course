package org.efremov.didemo.controllers;

import org.efremov.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
	@Autowired
	public GreetingService greetingService;
	
	public String sayHello() {
		return greetingService.getGreeting();
	}
}
