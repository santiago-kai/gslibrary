package com.sap.gslibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.gslibrary.entity.BookReader;

@Repository
public interface BookReaderRepository extends JpaRepository<BookReader, Integer> {
	BookReader findByUserId(String userId);
}
