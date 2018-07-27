package com.sap.gslibrary.service;

import java.sql.SQLException;
import java.util.List;

import com.sap.gslibrary.entity.Book;

public interface BookService {

	Book insertBook(Book Book) throws SQLException;
	
	List<Book> findByName(String name);
	
	Book findByIsbn(String isbn);
	
	List<Book> findAll();
	
	void deleteById(Integer id) throws SQLException;
	
	Book updateBook(Book book) throws SQLException;
	
}
