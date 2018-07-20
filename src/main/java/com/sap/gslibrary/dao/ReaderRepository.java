package com.sap.gslibrary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.gslibrary.entity.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
	List<Reader> findByName(String name);
}
