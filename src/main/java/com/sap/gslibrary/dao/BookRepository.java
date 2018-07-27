package com.sap.gslibrary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sap.gslibrary.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByName(String name);
	
	Book findByIsbn(String isbn);
}
