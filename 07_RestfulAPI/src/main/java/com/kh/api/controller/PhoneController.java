package com.kh.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Phone;

@RestController
public class PhoneController {
	@GetMapping("/phone")
	public ResponseEntity select() {
		// phone 전체 리스트
		return new ResponseEntity("sample",HttpStatus.OK);	// 데이터와 함께 상태와 관련된 걸 같이 보낼 수 있음
	}
	
	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num) {
		return new ResponseEntity("error", HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) {
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) {
		return new ResponseEntity(HttpStatus.BAD_REQUEST); 
	}
	
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	
}
