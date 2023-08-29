package com.kh.mvc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.MemberDAO;
import com.kh.mvc.model.vo.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public int registerMember(Member vo) {
		return dao.registerMember(vo);
	}
	
}
