package com.sap.gslibrary.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sap.gslibrary.entity.Book;
import com.sap.gslibrary.service.BookService;

@RestController
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
    @PostMapping("/book")
    public Book insertBook(@RequestParam("name") String name,
                       @RequestParam("donor") String donor,
                       @RequestParam("category") String category,
                       @RequestParam("description") String description) {
        Book book = new Book();
        book.setName(name);
        book.setDonor(donor);
        book.setCategory(category);
        book.setDescription(description);
        book.setPurchasingTime(new Date());
        book.setLastModified(new Date());
        
    	return bookService.insertBook(book);
    }

    @PostMapping("/books")
    public List<Book> findByName(@RequestParam("name") String name) {
        return bookService.findByName(name);
    }
    
    @GetMapping("/allbooks")
    public List<Book> findAll() {
    	return bookService.findAll();
    }
    
    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable("id") Integer id,
	    	           @RequestParam("name") String name,
	    	           @RequestParam("donor") String donor,
	                   @RequestParam("category") String category,
	                   @RequestParam("purchasingTime") Date purchasingTime,
	                   @RequestParam("description") String description,
	                   @RequestParam("borrower") String borrower,
	                   @RequestParam("borrowerTime") Date borrowerTime) {
    	Book book = new Book();
    	book.setId(id);
        book.setName(name);
        book.setDonor(donor);
        book.setCategory(category);
        book.setPurchasingTime(purchasingTime);
        book.setDescription(description);
        book.setBorrower(borrower);
        book.setBorrowerTime(borrowerTime);
        book.setLastModified(new Date());
    	
        return bookService.updateBook(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
    }

}
