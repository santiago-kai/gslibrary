package com.sap.gslibrary.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloWorld {
	
	@RequestMapping("/hello")
	public String helloWorld(){
		return "hello world";
	}
	
}
