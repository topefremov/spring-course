package org.efremov.spring5web.bootstrap;

import org.efremov.spring5web.model.Author;
import org.efremov.spring5web.model.Book;
import org.efremov.spring5web.model.Publisher;
import org.efremov.spring5web.repositories.AuthorRepository;
import org.efremov.spring5web.repositories.BookRepository;
import org.efremov.spring5web.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {
		Publisher packt = new Publisher("Packt");
		Publisher home = new Publisher("Home");
		
		publisherRepository.save(packt);
		publisherRepository.save(home);
		
		Author aleks = new Author("Aleksandr", "Efremov");
		Book aleksBook = new Book("How to code", "123456", packt);
		aleks.getBooks().add(aleksBook);
		aleksBook.getAuthors().add(aleks);
		
		
		authorRepository.save(aleks);
		bookRepository.save(aleksBook);
		
		Author elena = new Author("Elena", "Efremova");
		Book elenaBook = new Book("How to be at home", "12345678", home);
		elena.getBooks().add(elenaBook);
		
		authorRepository.save(elena);
		bookRepository.save(elenaBook);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}

}
