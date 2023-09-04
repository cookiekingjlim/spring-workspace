package com.kh.mvc.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Member;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate session;
	
	public int registerMember(Member vo) {
		return session.insert("memberMapper.registerMember", vo);
	}
	
	public Member getMemberById(String id) {
		return session.selectOne("memberMapper.getMemberById", id);
	}
	
	

}
