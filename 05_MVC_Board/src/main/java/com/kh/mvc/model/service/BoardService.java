package com.kh.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.BoardDAO;
import com.kh.mvc.model.vo.Board;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	
	public int insertBoard(Board board) {
		return dao.insertBoard(board);
	}
	
	public List<Board> selectAllBoard(){
		return dao.selectAllBoard();
	}

}
