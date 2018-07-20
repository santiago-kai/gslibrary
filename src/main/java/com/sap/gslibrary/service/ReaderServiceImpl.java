package com.sap.gslibrary.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.gslibrary.dao.ReaderRepository;
import com.sap.gslibrary.entity.Reader;

@Transactional
@Service
public class ReaderServiceImpl implements ReaderService {
	
	private ReaderRepository readerRepository;
	
	@Autowired
	public ReaderServiceImpl(ReaderRepository readersRepository) {
        this.readerRepository = readersRepository;
    }
	
	@Override
	public Reader insertReader(Reader reader) {
		if (reader != null) {
			readerRepository.save(reader);
        }
        return reader;
	}

	@Override
	public List<Reader> findByName(String name) {
		return readerRepository.findByName(name);
	}
	
	@Override
	public List<Reader> findAll() {
		return readerRepository.findAll();
	}
	
	@Override
	public void deleteById(Integer id) {
		readerRepository.delete(new Reader(id));
		
	}

	@Override
	public Reader updateReader(Reader reader) {
		return readerRepository.save(reader);
	}

}
