package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap07.Calculator;
import chap07.ExecuteTimeCalculator;
import chap07.ImplementCalculator;
import chap07.RecursiveCalculator;

public class Main {
	public static void main(String[] args){
		
		// Aspect 사용, 후킹, 빈 객체를 사용하는지 알 수 있음. 프록시는 알 수 없음
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopPojo.xml");
		
		Calculator aspectImplementCalc = ctx.getBean("implementCalculator",Calculator.class);
		Calculator aspectRecursiveCalc = ctx.getBean("recursiveCalculator",Calculator.class);
		
		long aspectResult1 = aspectImplementCalc.factorial(5000);
		long aspectResult2 = aspectRecursiveCalc.factorial(5000);
		
		
		
		
		
		
		////////////////////////////////////////////////////////////////////
		
		ImplementCalculator implementCalculator = new ImplementCalculator();
		RecursiveCalculator recursiveCalculator = new RecursiveCalculator();
		
		// 프록시 
		ExecuteTimeCalculator execTimeCalc1 = new ExecuteTimeCalculator(implementCalculator);
		ExecuteTimeCalculator execTimeCalc2 = new ExecuteTimeCalculator(recursiveCalculator);
		execTimeCalc1.factorial(5000);
		execTimeCalc2.factorial(5000);
		
		// 클래스를 사용하는 방법
		long start1 = System.currentTimeMillis();
		long result1 = implementCalculator.factorial(5000);
		long end1 = System.currentTimeMillis();
		
		long start2 = System.currentTimeMillis();
		long result2 = recursiveCalculator.factorial(5000);
		long end2 = System.currentTimeMillis();
		
		System.out.printf("실행시간1 = %d\n실행시간2 = %d\n",(end1-start1), (end2-start2));
	}
}
