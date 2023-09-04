package com.kh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.security.model.service.MemberService;
import com.kh.security.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder bcpe;
	
	@GetMapping("/all")
	public void all() {}
	
	@GetMapping("/member")
	public void member() {}
	
	@GetMapping("/admin")
	public void admin() {}
	
	@GetMapping("/login")
	public void login() {}

	@GetMapping("/logout")
	public void logout() {}
	
	@GetMapping("/error")
	public void error() {}
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(Member vo) {
		
		System.out.println("before password : " + vo.getPassword());
		
		// BcryptPasswordEncoder를 이용해서 암호화 처리
		String encodePassword = bcpe.encode(vo.getPassword());
		System.out.println("after password : " + encodePassword);
		
		vo.setPassword(encodePassword);
		
		service.registerMember(vo);
		return "redirect:/login";
	}
}
