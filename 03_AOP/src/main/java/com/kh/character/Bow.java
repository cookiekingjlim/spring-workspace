package com.kh.character;

public class Bow extends Weapon {

	public Bow() {}
	public Bow(String name) {
		super(name);
	}
	
	@Override
	public String attack() throws Exception {
		return "È°À» ½ð´Ù......";
	}
	
}
