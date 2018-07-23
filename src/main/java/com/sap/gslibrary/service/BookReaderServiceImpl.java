package com.sap.gslibrary.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.gslibrary.dao.BookReaderRepository;
import com.sap.gslibrary.entity.BookReader;

@Transactional
@Service
public class BookReaderServiceImpl implements BookReaderService {
	
	private BookReaderRepository readerRepository;
	
	@Autowired
	public BookReaderServiceImpl(BookReaderRepository readersRepository) {
        this.readerRepository = readersRepository;
    }
	
	@Override
	public BookReader insertReader(BookReader reader) {
		if (reader != null) {
			readerRepository.save(reader);
        }
        return reader;
	}

	@Override
	public BookReader findByUserId(String userId) {
		return readerRepository.findByUserId(userId);
	}
	
	@Override
	public List<BookReader> findAll() {
		return readerRepository.findAll();
	}
	
	@Override
	public void deleteById(Integer id) {
		readerRepository.delete(new BookReader(id));	
	}

	@Override
	public BookReader updateReader(BookReader reader) {		
		return readerRepository.save(reader);
	}

}
