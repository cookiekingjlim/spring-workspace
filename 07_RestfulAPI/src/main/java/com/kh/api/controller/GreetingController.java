package com.kh.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Greeting;

@RestController
public class GreetingController {

	// http://localhost:8080/api/greet --> selectList
	@GetMapping("/greet")
	public Greeting sayGreet() {
		return new Greeting(314L, "Restful API");
	}
	
	// http://localhost:8080/board/view?no=23 (X)
	// --> http://localhost:8080/board/23 --> selectOne
	@GetMapping("/greet/{id}")
	public String showSample(@PathVariable int id) {	// PathVariable : URL 경로의 일부를 파라미터로 사용할 때 
		return "Hello Rest API case number..." + id;
	}
	
	// http://localhost:8080/search?keyword=키워드
	@GetMapping("/greet2")
	public Greeting sayGreet2(String content) {
		return new Greeting(500L, content);
	}
}
