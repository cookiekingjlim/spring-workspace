package com.kh.di;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Greet {
	
	private String message;
	
	public Greet() {
		System.out.println(getClass().getName() + "...Instance Create..");
	}
	public Greet(String message) {
		this.message = message;
	}
	
	public void printMessage() {
		System.out.println(getClass().getName() + "=>" + message);
	}
}
