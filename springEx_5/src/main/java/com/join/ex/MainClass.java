package com.join.ex;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String config = null;
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.next();
		System.out.println("입력하시오.");
		if(str.equals("dev")) {
			config = "dev";
		}else if(str.equals("run")){
			config = "run";
		}
		
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("applicationCTX_run", "applicationCTX_dev");
		
		ServerInfo info = ctx.getBean("serverinfo", ServerInfo.class);
		System.out.println("IP NUM : "+ info.getIpNum());
		System.out.println("PORT NUM : " + info.getPortNum());
		ctx.close();
	}

}
