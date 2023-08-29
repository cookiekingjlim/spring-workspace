package com.kh.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@RequestMapping("search")
	public String search() {
		return "search";
	}
	
	@RequestMapping("find")
	public String find(String keyword, Model model) {
		System.out.println(keyword);
		// 서비스 - 비즈니스 로직 처리~!
		// -> list 값! 데이터 바인딩 -> Model
//		model.addAttribute("list",list);
		return "find_ok";	// "find_fail"
	}
	
	@RequestMapping("register")
	public String register() {
		return "register";	//단순 페이지 이동이니까 바로 register 리턴으로 던져
	}
	
	@RequestMapping("signUp")
	public String signUp(Member member) {
//		System.out.println(member);
	
		return "redirect:/";	//index.jsp로 바로 넘어감
	}
	
	//login - 페이지 이동
	
	// signIn - 비즈니스 로직 포함 : 파라미터 값 -> httpServletRequest request
	// return "login_result"
	
	
	// allMember - 비즈니스 로직 포함, 데이터 바인딩-Model
	// --> return "find_ok";
	
	// logout - 로그아웃 기능
	
	// update - 페이지 이동
	
	// updateMember - 비즈니스 로직 포함 -> 파라미터 request 필요
	
	
	
	
}

