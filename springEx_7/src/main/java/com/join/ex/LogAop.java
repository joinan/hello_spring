package com.join.ex;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // 이클래스가 Aspect 역할을 할 것이다
public class LogAop {
	
	@Pointcut("within(com.join.ex.*)") // 핵심코드에 적용될 범위를 지정해야한다.
	private void pointcutMethod(){ // 포인트컷이라는 메소드를 하나 가지고 있어야 한다.
		
	}
	
	@Around("pointcutMethod()") // loggerAop가 포인트컷메소드를 찾아가서 포인트컷이 지정된 범위에 적용됨
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + " is start");
		long st = System.currentTimeMillis();
		
		try{
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " 경과시간 : " + (et-st));
		}
	}
	
	@Before("within(com.join.ex.*")
	public void beforAdvice() {
		System.out.println("beforAdvice()");
	}
	
}
