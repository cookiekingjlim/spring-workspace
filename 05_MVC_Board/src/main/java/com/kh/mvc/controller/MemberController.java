package com.kh.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder bcpe;
	
	@GetMapping("/member/register")
	public void register() {
		System.out.println("왜 안들어와아아ㅏㅏ");
	}

	@GetMapping("/member/login")
	public void login() {}
	
	@PostMapping("/member/register")
	public String register(Member vo) {
		System.out.println("오ㅓㅐ또안와아ㅏㅏㅏ");
		
		String encodedPassword = bcpe.encode(vo.getPassword());
		System.out.println("after password : " + encodedPassword);
		
		vo.setPassword(encodedPassword);
		
		service.registerMember(vo);
		return "redirect:/board/list";
	}
	
//	@GetMapping("member/logout")
//	public void logout() {}
}
