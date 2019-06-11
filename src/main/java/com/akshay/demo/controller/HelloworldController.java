package com.akshay.demo.controller;

import java.sql.SQLException;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.demo.config.HelloConfig;

@RestController
public class HelloworldController {
	@Autowired
	HelloConfig config;
	@Autowired
	DataSource datasource;
	
	@GetMapping("/hello")
    public Collection<String> sayHello() {
        return IntStream.range(0, 10)
          .mapToObj(i -> "Hello number " + i)
          .collect(Collectors.toList());
    }
	
	@GetMapping("/hello/message")
	public String sayHelloMessage() {
		String returnMessage = null;
		try {
			returnMessage = config.getMessage() + datasource.getConnection().toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnMessage;
	}
}
