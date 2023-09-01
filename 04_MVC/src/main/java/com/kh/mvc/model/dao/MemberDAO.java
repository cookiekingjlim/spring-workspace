package com.kh.mvc.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.mvc.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int registerMember(Member vo) {
		return sqlSession.insert("memberMapper.registerMember",vo);
	}
	
	public List<Member> showAllMember(){
		return sqlSession.selectList("memberMapper.allMember");
	}
	
	public List<Member> findMember(String keyword){
		return sqlSession.selectList("memberMapper.findMember");
	}
	/*
	 * showAllMember
	 * findMember -> 파라미터 : String keyword,	return : List<Member> 	// 이름으로도 검색되고 주소로도 검색되고...
	 * login -> 파라미터 : Member vo
	 * updateMember -> 파라미터: Member vo
	 * */
}
