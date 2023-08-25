package com.kh.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloTestApp3UsingSpring {

	public static void main(String[] args) {
		//1. BeanFactory 생성... 주문서는 공장에서 미리 받아서 읽기
		// Bean Configuration File : 빈(Bean) 설정 문서
		System.out.println("1. BeanFactory 생성...");
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/hello.xml"));
		
		//2. getBean()으로 빈을 받아와서 printMessage() 호출
		System.out.println("2. getBean() 클라이언트 호출...");
		Hello hello = (Hello) factory.getBean("hello");
		hello.printMessage();
	}

}
