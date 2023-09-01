package com.kh.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.hamcrest.core.IsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

@Controller
@RequestMapping("/board/*")	// 공틍 빼서 -> board안에 전체
public class BoardController {
	
	String path="D:\\spring-workspace\\05_MVC_Board\\src\\main\\webapp\\upload\\";	// 여기저기 사용됨으로 전역변수 설정
	
	@Autowired
	private BoardService service;
	
//	@RequestMapping("/list")	// 풀어서 쓰면 value="/list", method=RequestMethod.Get)
	@GetMapping("/list")	//=> 22행 대신 이렇게 씀
	public void list(Criteria cri, Model model) {	//@RequestMapping("board/list")여기랑 return값 경로 일치시키면 String 대신 void 처리해도 됨 
		List<Board> list = service.selectAllBoard(cri);
		model.addAttribute("list",list);
		model.addAttribute("paging", new Paging(cri, service.getTotal()));
//		return "board/list";	// 모델앤뷰 사용했을 시 넘기는 방법, jsp경로, 리스트, 리스트
	}
	
	@GetMapping("/insert")
	public void insert() {
		
	}
	
	@PostMapping("/insert")
	public String insert(Board board) throws IllegalStateException, IOException {	// 게시글 등록 페이지에서 -> 게시글 작성 후 등록시 처리되어야 하는 로직
		// 파일 업로드 기능
		fileUpload(board);
		
		service.insertBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/view")
	public void view(int no, Model model) {
//		Board board = service.selectBoard(no);
//		model.addAttribute("board",board);
		model.addAttribute("vo", service.selectBoard(no));
	}
	
	@GetMapping("/update")
	public void update(int no, Model model) {
		model.addAttribute("vo", service.selectBoard(no));
	}
	
	// 파일 업로드 메서드 따로 빼서 가져다가 써
	public void fileUpload(Board board) throws IllegalStateException, IOException {

		// 파일 업로드 기능 추가
		MultipartFile file = board.getUploadFile();
		if(!file.isEmpty()) {// 업로드한 파일이 있을 때만
			
			// 기존에 파일이 있는 경우에만 삭제 가능하게!
			if(board.getUrl() != null) {
				File delFile = new File(path+board.getUrl().replace("/upload/", ""));	//업로드에 해당하는 부분 지우고 파일명만 남게
				delFile.delete();
			}
			
			System.out.println("파일의 사이즈 : " + file.getSize());
			System.out.println("업로드된 파일명 : " + file.getOriginalFilename());
			System.out.println("파일의 파라미터명 : " + file.getName());
			
			
			// 중복 방지를 위한 UUID 적용
			UUID uuid = UUID.randomUUID();
			String filename = uuid.toString()+"_"+file.getOriginalFilename();
			
			File copyFile = new File(path, filename);
			file.transferTo(copyFile);// 업로드한 파일이 지정한 path 위치로 저장
			
			// 데이터베이스에 경로 저장!
			// 주의 : 톰캣이 접근 못하게 만들어.... => 톰캣 xml 수정해야함
			board.setUrl("/upload/" + filename);	//board가 url 담아서 업데이트로 감 => 매퍼로 가야함 url=#{url} 추가
		}
	}
	
	@PostMapping("/update")
	public String update(Board board) throws IllegalStateException, IOException {
		// 파일 업로드 기능
		fileUpload(board);
		
		service.updateBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete")
	public String delete(int no) {
		
		Board board = service.selectBoard(no);
			if(board.getUrl() != null) {
				File delFile = new File(path+board.getUrl().replace("/upload/", ""));	//업로드에 해당하는 부분 지우고 파일명만 남게
				delFile.delete();
		}
		
		service.deleteBoard(no);
		return "redirect:/board/list";
	}

	@RequestMapping("/download")
	public ModelAndView downloadFile(String filename) {
		HashMap map = new HashMap();
		map.put("path", path);
		return new ModelAndView("downloadView", map);
		
	}
}
