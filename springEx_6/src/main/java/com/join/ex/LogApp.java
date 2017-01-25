package com.join.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogApp {
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString(); // 어떤 메소드인지 이름을 출력
		System.out.println(signatureStr + " is start."); // 메소드가 실행되었다고 알림
		long st = System.currentTimeMillis(); // 공통기능
		
		try{
			Object obj = joinpoint.proceed(); // 프록시. 실제로 조인포인트를 실행. 
			return obj; // 오브젝트를 반환 
		} finally{  // 마지막으로 실행됨.
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " 경과시간 : " + (et-st));
		}
	}
}
