package com.sap.gslibrary.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.sap.gslibrary.entity.BookReader;
import com.sap.gslibrary.service.BookReaderService;

@RestController
public class BookReaderController {
	
	private BookReaderService readerService;

    @Autowired
    public BookReaderController(BookReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping("/bookreader")
    public BookReader insertReader(@RequestParam("userId") String userId,
    		                   @RequestParam("name") String name,
    		                   @RequestParam("borrowBooksCount") Integer borrowBooksCount) {
    	BookReader reader = new BookReader();
    	reader.setUserId(userId);
    	reader.setName(name);
    	reader.setBorrowBooksCount(borrowBooksCount);
    	reader.setLastModified(new Date());
    	
        return readerService.insertReader(reader);
    }

    @GetMapping("/bookreader/{userId}")
    public BookReader findByUserId(@PathVariable("userId") String userId) {
        return readerService.findByUserId(userId);
    }
    
    @GetMapping("/allbookreaders")
    public List<BookReader> findAll() {
    	return readerService.findAll();
    }
    
    @PutMapping("/bookreader/{id}")
    public BookReader updateReader(@PathVariable("id") Integer id,
					    	   @RequestParam("userId") String userId,
					           @RequestParam("name") String name,
					           @RequestParam("borrowBooksCount") Integer borrowBooksCount) {
    	BookReader reader = new BookReader();
    	reader.setId(id);
    	reader.setUserId(userId);
    	reader.setName(name);
    	reader.setBorrowBooksCount(borrowBooksCount);
    	reader.setLastModified(new Date());
    	
        return readerService.updateReader(reader);
    }

    @DeleteMapping("/bookreader/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        readerService.deleteById(id);
    }

}
