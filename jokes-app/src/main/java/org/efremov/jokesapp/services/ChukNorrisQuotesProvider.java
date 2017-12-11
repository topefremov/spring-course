package org.efremov.jokesapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class ChukNorrisQuotesProvider implements RandomQuotesService {
	
	private final ChuckNorrisQuotes chuckNorrisQuotes;
	
	@Autowired
	public ChukNorrisQuotesProvider(ChuckNorrisQuotes chuckNorrisQuotes) {
		super();
		this.chuckNorrisQuotes = chuckNorrisQuotes;
	}

	@Override
	public String getQuote() {
		return chuckNorrisQuotes.getRandomQuote();
	}
	
}
