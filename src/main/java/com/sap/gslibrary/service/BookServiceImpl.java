package com.sap.gslibrary.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.gslibrary.dao.BookRepository;
import com.sap.gslibrary.entity.Book;

@Transactional
@Service
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public Book insertBook(Book book) {
		if (book != null) {
			bookRepository.save(book);
		}
		return book;
	}

	@Override
	public List<Book> findByName(String name) {
		return bookRepository.findByName(name);
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		bookRepository.delete(new Book(id));
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

}
