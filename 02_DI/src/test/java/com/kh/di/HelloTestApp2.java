package com.kh.di;

public class HelloTestApp2 {

	public static void main(String[] args) {
		//1. 사용할 bean(컴포넌트) 정보를 갖는 hello.properties를 parsing, Bean 객체를 생성할 HelloFactory 객체 생성
		HelloFactory helloFactory = HelloFactory.getInstance();
		
		//2. helloFactory 객체로 parsing 할 resource 전달
		helloFactory.setConfigResource("./src/main/resources/config/hello.properties");
		
		//3. helloFactory 객체로부터 instance.one 이름을 갖는 Hello 객체 요청
		Hello hello = helloFactory.getBean("instance.one");
		
		//4. printMessage() 호출
		hello.printMessage();
	}

}
