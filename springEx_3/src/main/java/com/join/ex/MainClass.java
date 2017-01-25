package com.join.ex;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;



public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext(); // 컨택스트 가져옴
		ConfigurableEnvironment env = ctx.getEnvironment(); // Environment 객체 가져옴 
		MutablePropertySources propertySources = env.getPropertySources(); // propertySource가져옴
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			// 외부 파일을 ResourcePropertySource 객체로 만들어서 propertySource 집합체에 추가한다.
			System.out.println(env.getProperty("admin.id")); // env 객체에서 원하는 프로퍼티 추출
			System.out.println(env.getProperty("admin.pw"));
		} catch (IOException e) {}
		
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx; //컨텍스트 설정
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();
	}



}
