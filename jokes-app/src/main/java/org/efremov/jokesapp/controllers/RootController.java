package org.efremov.jokesapp.controllers;

import org.efremov.jokesapp.services.RandomQuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	
	RandomQuotesService quotesService;
	
	@Autowired
	public RootController(RandomQuotesService quotesService) {
		super();
		this.quotesService = quotesService;
	}

	@RequestMapping("/")
	public String getJoke(Model model) {
		model.addAttribute("joke", quotesService.getQuote());
		return "joke";
	}
}
