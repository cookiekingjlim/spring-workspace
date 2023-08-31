package com.kh.mvc.model.vo;

import lombok.Getter;

@Getter
public class Paging {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int num = 10;	// 한 페이지에 보여질 개수
	
	private int total;	// 전체 개수
	private Criteria cri;	// 현재 페이지에 대한 정보는 Criteria 객체가 가지고 있음
	
	public Paging(Criteria cri, int total) {
		this.cri = cri;
		this.total = total; 
		
		this.endPage = (int) Math.ceil((double)cri.getPage() / this.num) * this.num;
		this.startPage = this.endPage - this.num + 1;
		
		int lastPage = (int) Math.ceil((double) total / cri.getAmount());
		
		if(lastPage < this.endPage) {
			this.endPage = lastPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < lastPage;
	}
}
