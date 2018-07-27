package com.sap.gslibrary.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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

    @PostMapping("/insertbookreader")
    public BookReader insertBookReader(@Valid BookReader bookReader, BindingResult bindingResult) {
    	BookReader bkReader = new BookReader();
    	bkReader.setUserId(bookReader.getUserId());
    	bkReader.setName(bookReader.getName());
    	bkReader.setBorrowBooksCount(bookReader.getBorrowBooksCount());
    	bkReader.setLastModified(new Date());
    	
        return readerService.insertReader(bkReader);
    }

    @GetMapping("/findbookreader")
    public BookReader findBookReaderByUserId(@RequestParam("userId") String userId) {
        return readerService.findByUserId(userId);
    }
    
    @GetMapping("/allbookreaders")
    public List<BookReader> findAllBookReader() {
    	return readerService.findAll();
    }
    
    @PutMapping("/updatebookreader")
    public BookReader updateBookReader(@Valid BookReader bookReader, BindingResult bindingResult) {
    	BookReader bkReader = new BookReader();
    	bkReader.setId(bookReader.getId());
    	bkReader.setUserId(bookReader.getUserId());
    	bkReader.setName(bookReader.getName());
    	bkReader.setBorrowBooksCount(bookReader.getBorrowBooksCount());
    	bkReader.setLastModified(new Date());
    	
        return readerService.updateReader(bkReader);
    }

    @DeleteMapping("/deletebookreader")
    public void deleteBookReaderById(@RequestParam("id") Integer id) {
        readerService.deleteById(id);
    }

}
