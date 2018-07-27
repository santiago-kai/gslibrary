package com.sap.gslibrary.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.gslibrary.dao.BookRepository;
import com.sap.gslibrary.entity.Book;
import com.sap.gslibrary.enums.BookResultEnum;
import com.sap.gslibrary.exception.BookException;

@Transactional
@Service
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public Book insertBook(Book book) throws SQLException {
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
	public Book findByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn);
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) throws SQLException {
		bookRepository.delete(new Book(id));
	}

	@Override
	public Book updateBook(Book book) throws SQLException {
		Optional<Book> bookTemp = bookRepository.findById(book.getId());
		if (! bookTemp.isPresent()) {
			throw new BookException(BookResultEnum.BOOK_NOT_FOUND);
		}else if (book.getBorrower() != null && ! book.getBorrower().equals("")
				&& bookTemp.get().getBorrower() != null 
	            && ! bookTemp.get().getBorrower().equals("")) {
			//book which is not return can't be borrow 
			throw new BookException(BookResultEnum.BOOK_UNAVAILABLE);		
		}
		book.setLastModified(new Date());
		return bookRepository.save(book);
	}

}
