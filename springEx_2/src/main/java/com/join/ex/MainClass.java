package com.join.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationCTX.xml");
		
		System.out.println("리프레시 전입니다");
		ctx.refresh();
		System.out.println("리프레시 한다음 ");
		System.out.println("클리어 하기 전 ");
		ctx.close();
		System.out.println("클리어 하고 나서");
	}

}
