package com.sap.gslibrary.service;

import java.util.List;

import com.sap.gslibrary.entity.Reader;

public interface ReaderService {

	Reader insertReader(Reader reader);
	
	List<Reader> findByName(String name);
	
	List<Reader> findAll();
	
	void deleteById(Integer id);
	
	Reader updateReader(Reader reader);
	
}
