package com.sap.gslibrary.service;

import java.util.List;

import com.sap.gslibrary.entity.BookReader;

public interface BookReaderService {

	BookReader insertReader(BookReader reader);
	
	BookReader findByUserId(String userId);
	
	List<BookReader> findAll();
	
	void deleteById(Integer id);
	
	BookReader updateReader(BookReader reader);
	
}
