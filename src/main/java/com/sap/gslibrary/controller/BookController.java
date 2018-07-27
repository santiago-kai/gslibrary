package com.sap.gslibrary.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sap.gslibrary.entity.Book;
import com.sap.gslibrary.entity.Result;
import com.sap.gslibrary.service.BookService;
import com.sap.gslibrary.utils.ResultUtil;

@RestController
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
    @SuppressWarnings("unchecked")
	@PostMapping("/insertbook")
    public Result<Book> insertBook(@Valid Book book, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
    	
    	Book bk = new Book();
        bk.setName(book.getName());
        bk.setIsbn(book.getIsbn());
        bk.setDonor(book.getDonor());
        bk.setCategory(book.getCategory());
        bk.setDescription(book.getDescription());
        bk.setPurchasingTime(new Date());
        bk.setLastModified(new Date());
        
    	return ResultUtil.success(bookService.insertBook(bk));
    }

    @PostMapping("/findbooksbyname")
    public List<Book> findByName(@RequestParam("name") String name) {
        return bookService.findByName(name);
    }
    
    @PostMapping("/findbooksbyisbn")
    public Book findByIsbn(@RequestParam("isbn") String isbn) {
        return bookService.findByIsbn(isbn);
    }
    
    @GetMapping("/allbooks")
    public List<Book> findAll() {
    	return bookService.findAll();
    }
    
    @PutMapping("/updatebook")
    public Book updateBook(@Valid Book book, BindingResult bindingResult) throws SQLException {
//    	Book bk = new Book();
//    	bk.setId(book.getId());
//        bk.setName(book.getName());
//        bk.setIsbn(book.getIsbn());
//        bk.setDonor(book.getDonor());
//        bk.setCategory(book.getCategory());
//        bk.setPurchasingTime(book.getPurchasingTime());
//        bk.setDescription(book.getDescription());
//        bk.setBorrower(book.getBorrower());
//        bk.setBorrowerTime(book.getBorrowerTime());
//        bk.setLastModified(new Date());
    	
        return bookService.updateBook(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteById(@PathVariable("id") Integer id) throws SQLException {
        bookService.deleteById(id);
    }

}
