package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
//	private static Assembler assembler = new Assembler();
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) {
		// 스프링 사용
		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 어셈블러 객체를 만들어 인스턴스를 받아서 사용
//		MemberRegisterService registerService = assembler.getMemberRegisterService();
		
		// 스프링
		MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
		
		// 회원등록
		RegisterRequest request = new RegisterRequest();
		request.setEmail("test@test.net");
		request.setName("홍길동");
		request.setPassword("1234");
		request.setConfirmPassword("1234");
		try{
			registerService.regist(request);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 암호변경 클래스 사용
//		ChangePasswordService changePasswordService = assembler.getChangePasswordService();
		
		// 스프링
		ChangePasswordService changePasswordService = ctx.getBean("changePasswordService", ChangePasswordService.class);
		try{
			changePasswordService.changePassword("test@test.net", "1234", "7777");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		// 스프링
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		infoPrinter.printMemberInfo("test@test.net");
		
	}
}
