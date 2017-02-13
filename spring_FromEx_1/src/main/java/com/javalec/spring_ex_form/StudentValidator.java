package com.javalec.spring_ex_form;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override // 검증할 객체의 클래스 타입 정보
	public boolean supports(Class<?> arg0) {
		return Student.class.isAssignableFrom(arg0);
	}

	@Override // 검증 메소드
	public void validate(Object obj, Errors errors) {
		System.out.println("validate()");
		Student student = (Student)obj;
		
		String studentName = student.getName();
		if(studentName == null || studentName.trim().isEmpty()){
			System.out.println("studentName is null or empty");
			errors.reject("name","trouble"); // 에러가 있으면 errors객체에 담는다
		}
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studentId is null");
			errors.reject("name","trouble");
		}
		
	}

}
