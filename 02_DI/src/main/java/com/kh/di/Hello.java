package com.kh.di;

import lombok.Data;

@Data
public class Hello {
	
	private String message = "Hello~";
	
	public Hello() {
		System.out.println(getClass().getName() + "...Instance Create....");
	}
	
	public void printMessage() {
		System.out.println(getClass().getName() + "=>" + message);
	}

}
