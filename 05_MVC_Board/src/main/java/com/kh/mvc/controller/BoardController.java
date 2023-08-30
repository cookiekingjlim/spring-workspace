package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;

@Controller
@RequestMapping("/board/*")	// 공틍 빼서 -> board안에 전체
public class BoardController {
	
	@Autowired
	private BoardService service;
	
//	@RequestMapping("/list")	// 풀어서 쓰면 value="/list", method=RequestMethod.Get)
	@GetMapping("/list")	//=> 22행 대신 이렇게 씀
	public void list(Model model) {	//@RequestMapping("board/list")여기랑 return값 경로 일치시키면 String 대신 void 처리해도 됨 
		List<Board> list = service.selectAllBoard();
		model.addAttribute("list",list);
//		return "board/list";	// 모델앤뷰 사용했을 시 넘기는 방법, jsp경로, 리스트, 리스트
	}
	


}
