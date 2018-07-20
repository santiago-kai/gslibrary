package com.sap.gslibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.gslibrary.entity.Reader;
import com.sap.gslibrary.service.ReaderService;

@RestController
@RequestMapping("/readers")
public class ReaderController {
	
	private ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping("/reader")
    public Reader insertReader(Reader reader) {
        return readerService.insertReader(reader);
    }

    @GetMapping("/readers/{name}")
    public List<Reader> findByName(@PathVariable(value = "name") String name) {
        return readerService.findByName(name);
    }
    
    @GetMapping("/allreaders")
    public List<Reader> findAll() {
    	return readerService.findAll();
    }
    
    @PutMapping("/reader")
    public Reader updateReader(Reader reader) {
        return readerService.updateReader(reader);
    }

    @DeleteMapping("/reader")
    public void deleteById(Integer id) {
        readerService.deleteById(id);
    }

}
