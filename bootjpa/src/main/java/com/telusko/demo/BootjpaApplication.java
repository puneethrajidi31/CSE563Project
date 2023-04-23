package com.telusko.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.telusko.demo.Service.Emailservice;

@SpringBootApplication
public class BootjpaApplication {
	
	@Autowired
	private Emailservice emailservice;

	public static void main(String[] args) {
		
		
 
		SpringApplication.run(BootjpaApplication.class, args);
	}

}
