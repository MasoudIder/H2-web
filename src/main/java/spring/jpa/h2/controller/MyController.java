package spring.jpa.h2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.jpa.h2.model.Book;
import spring.jpa.h2.model.repository.AuthorRepository;
import spring.jpa.h2.model.repository.BookRepository;

@Controller
public class MyController {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public MyController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books",bookRepository.findAll());

        return "books";
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authorRepository.findAll());
        return "authors";
    }

}
