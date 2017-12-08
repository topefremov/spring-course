package org.efremov.jokesapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class ChukNorrisQuotesProvider implements RandomQuotesService {
	
	private ChuckNorrisQuotes quotes = new ChuckNorrisQuotes();

	@Override
	public String getQuote() {
		return quotes.getRandomQuote();
	}
	
}
