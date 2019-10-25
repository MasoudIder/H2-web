package spring.jpa.h2;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring.jpa.h2.model.Author;
import spring.jpa.h2.model.Book;
import spring.jpa.h2.model.Publisher;
import spring.jpa.h2.model.repository.AuthorRepository;
import spring.jpa.h2.model.repository.BookRepository;
import spring.jpa.h2.model.repository.PublisherRepository;

@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    public void init(){
        Publisher publisher=new Publisher();
        publisher.setAddress("isfahan");
        publisher.setName("Jungle");

        Author author = new Author("masoud", "kalali");
        Book book = new Book("sdn", "123",publisher);

        book.getAuthors().add(author);
        author.getBooks().add(book);
        publisherRepository.save(publisher);

        authorRepository.save(author);
        bookRepository.save(book);

        Author author2 = new Author("hassn", "lkr");
        Book book2 = new Book("sdn clod", "1234",publisher);

        book2.getAuthors().add(author2);
        author2.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);


    }
}
