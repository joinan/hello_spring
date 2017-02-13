package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import config.JavaConfig;

public class Main {
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args){
		// XML을 이용
		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// Java 이용
//		ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
		ChangePasswordService changePasswordService = ctx.getBean("changePasswordService", ChangePasswordService.class);
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
	}
	
}
