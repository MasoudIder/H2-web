package spring.jpa.h2.model.repository;

import org.springframework.data.repository.CrudRepository;
import spring.jpa.h2.model.Author;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
}
