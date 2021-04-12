package com.bookstore.demo.controller;

import com.bookstore.demo.model.Book;
import com.bookstore.demo.repository.BookRepository;
import com.bookstore.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class BookController {
    private BookService bookService;
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    //Endpoints
    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello world";
    }

    //Get all books
    // http://localhost:9090/api/books/
    @GetMapping("/books")
    public List<Book> getBooks() {
        System.out.println("calling getBooks ==>");
        return bookService.getBooks();
    }
    //Create a book
    // http://localhost:9090/api/books/
    @PostMapping(path = "/books")
    public Book createBook(@RequestBody Book bookObject) {
        System.out.println("calling createBook ==>");
        return bookService.createBook(bookObject);
    }

    //end
}




