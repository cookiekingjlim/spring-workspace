package com.kh.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {
	
	private String name;
	private int level;
	private Weapon weapon;
	
	public String quest(String qeustName) throws Exception {
		System.out.println(qeustName + "퀘스트 진행 중...");
		return qeustName + "퀘스트 진행 중";
	}
	
}
