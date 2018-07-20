package com.sap.gslibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.gslibrary.entity.Book;
import com.sap.gslibrary.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
    @PostMapping("/book")
    public Book insertBook(Book book) {
        return bookService.insertBook(book);
    }

    @GetMapping("/books")
    public List<Book> findByName(String name) {
        return bookService.findByName(name);
    }
    
    @GetMapping("/allbooks")
    public List<Book> findAll() {
    	return bookService.findAll();
    }
    
    @PutMapping("/book")
    public Book updateBook(Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/book")
    public void deleteById(Integer id) {
        bookService.deleteById(id);
    }

}
