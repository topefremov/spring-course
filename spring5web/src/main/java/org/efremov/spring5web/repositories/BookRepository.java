package org.efremov.spring5web.repositories;

import org.efremov.spring5web.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
}
