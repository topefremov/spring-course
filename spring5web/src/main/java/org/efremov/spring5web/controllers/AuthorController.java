package org.efremov.spring5web.controllers;

import org.efremov.spring5web.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
	
	private AuthorRepository authorRepository;
	
	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	@RequestMapping("/authors")		
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		return "authors";
	}
}
