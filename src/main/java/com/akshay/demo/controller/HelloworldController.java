package com.akshay.demo.controller;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.demo.config.HelloConfig;

@RestController
public class HelloworldController {
	@Autowired
	HelloConfig config;
	
	@GetMapping("/hello")
    public Collection<String> sayHello() {
        return IntStream.range(0, 10)
          .mapToObj(i -> "Hello number " + i)
          .collect(Collectors.toList());
    }
	
	@GetMapping("/hello/message")
	public String sayHelloMessage() {
		return config.getMessage();
	}
}
