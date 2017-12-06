package org.efremov.spring5web.controllers;

import org.efremov.spring5web.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	private BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "books";
	}
}
