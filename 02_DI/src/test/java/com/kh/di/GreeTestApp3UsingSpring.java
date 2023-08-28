package com.kh.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class GreeTestApp3UsingSpring {

	public static void main(String[] args) {
		
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/greet.xml"));
		
		Greet g1 = (Greet) factory.getBean("greet1");
		g1.printMessage();
		
		Greet g2 = (Greet) factory.getBean("greet2");
		g2.printMessage();
		
		Greet g3 = (Greet) factory.getBean("greet3");
		g3.printMessage();
		
		Greet g4 = (Greet) factory.getBean("greet4");
		g4.printMessage();
		
	}

}
