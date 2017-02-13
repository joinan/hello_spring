package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class ExecuteTimeAspect {
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.nanoTime();
		try{
			Object result = joinPoint.proceed();
			return result;
		} finally{
			long finish = System.nanoTime();
			Signature signature = joinPoint.getSignature();
			System.out.printf("%s.%s(%s, args) 실행 시간 = %d ns\n",joinPoint.getTarget().getClass().getSimpleName(),
					signature.getName(), Arrays.toString(joinPoint.getArgs()),
					(finish - start));
		}
	}
}