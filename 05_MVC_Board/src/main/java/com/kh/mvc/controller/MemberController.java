package com.kh.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.mvc.model.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/register")
	public void register() {}
	
}
