package spring.jpa.h2.model.repository;

import org.springframework.data.repository.CrudRepository;
import spring.jpa.h2.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Integer> {
}
