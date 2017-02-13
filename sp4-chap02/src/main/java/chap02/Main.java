package chap02;

// maven으로 다운로드 받은 스프링 파일
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args){
		
		// 기존에 자바 클래스 방식
		Greeter greeter = new Greeter();
		greeter.setFormat("%s, 안녕하세요");
		System.out.println(greeter.greet("자바"));
		
		// 스프링
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Greeter greeterBean = ctx.getBean("greeter", Greeter.class);
		String msg = greeterBean.greet("스프링");
		System.out.println(msg);
		ctx.close();
	}
}
