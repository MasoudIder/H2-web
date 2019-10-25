package spring.jpa.h2.model.repository;

import org.springframework.data.repository.CrudRepository;
import spring.jpa.h2.model.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
}
