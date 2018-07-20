package com.sap.gslibrary.service;

import java.util.List;

import com.sap.gslibrary.entity.Book;

public interface BookService {

	Book insertBook(Book Book);
	
	List<Book> findByName(String name);
	
	List<Book> findAll();
	
	void deleteById(Integer id);
	
	Book updateBook(Book book);
	
}
