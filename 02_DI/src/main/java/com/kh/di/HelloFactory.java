package com.kh.di;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// hello.properties(부가정보, meta-data)의 내용을 읽어 Hello 객체를 생성해서 return하는 역할을 한다.
public class HelloFactory {
	
	private Hello hello;
	private Properties properties;
	
	// 공장은 하나니까 싱글톤 패턴으로 만들어둠
	private static HelloFactory helloFactory;
	private HelloFactory() {}
	public synchronized static HelloFactory getInstance() {	//synchronized 내부적으로 처리 및 동기화하기위해 사용..
		if(helloFactory == null) {
			helloFactory = new HelloFactory();
		}
		return helloFactory;
	}
	
	// properties file을 추상화, 캡슐화한 java.util.Properties 객체 생성
	public void setConfigResource(String configResource) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(configResource);	//리소스 받아서 여기에 받아오는 인풋스트림
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// name에 해당하는 객체 생성
	private void newInstanceHello(String name) {
		String className = properties.getProperty(name).trim();	//프로퍼티스에 공백 있을까봐 트림
		System.out.println("hello.properties에서 추출한 className : " + className);
		
		Class cls;
		try {
			cls = Class.forName(className);
			Object obj = cls.newInstance();
			if(obj instanceof Hello) {
				this.hello = (Hello)obj;	// hello이면 obj에 담아
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// Hello 객체 생성하는 newInstanceHello() 호출 및 Hello 객체를 return
	public Hello getBean(String name) {
		this.newInstanceHello(name);
		return hello;
	}
 
}
