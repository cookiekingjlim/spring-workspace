package com.kh.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.kh.api.service.PhoneService;

@RestController
public class PhoneController {
	@Autowired
	private PhoneService service;
	
	@GetMapping("/phone")
	public ResponseEntity select() {
		// phone 전체 리스트
		try {	// 조건을 걸어도 되고 트라이캐치로 해도 되고....
			List<Phone> list = service.select();
			return new ResponseEntity(list,HttpStatus.OK);	// 데이터와 함께 상태와 관련된 걸 같이 보낼 수 있음
		} catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);	// 데이터와 함께 상태와 관련된 걸 같이 보낼 수 있음
		}
	}
	// http://localhost:8080/api/phone/ZF01
	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num) {
		try {
			Phone phone = service.select(num);
			return new ResponseEntity(phone, HttpStatus.OK);
		} catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	// http://localhost:8080/api/phone
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) {
		try {
			int result = service.insert(phone);
			return new ResponseEntity(result, HttpStatus.OK);
		} catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	// http://localhost:8080/api/phone
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) {
		try {
			int result = service.update(phone);
			return new ResponseEntity(HttpStatus.OK);	//result 보내도 되고 안 보내도 돼
		} catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	// http://localhost:8080/api/phone/test2
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		try {
			service.delete(num);
			return new ResponseEntity(HttpStatus.OK);	//result 보내도 되고 안 보내도 돼
		} catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

	}
	
	
	
}
