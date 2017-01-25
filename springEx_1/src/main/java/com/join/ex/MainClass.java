package com.join.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 생성 
		ctx.load("classpath:applicationCTX.xml"); // 설정
		ctx.refresh();
		
		Student student = ctx.getBean("student", Student.class); // 사용 
		System.out.println("이름 : " + student.getName());
		System.out.println("나이 : " + student.getAge());
		
		ctx.close(); // 해제 
	}

}
