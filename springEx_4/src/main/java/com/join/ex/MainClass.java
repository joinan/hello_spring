package com.join.ex;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		
		try{
			propertySources.addLast(new ResourcePropertySource("classpath:file.property"));
			
			System.out.println(env.getProperty("admin.id"));
			System.out.println(env.getProperty("admin.pw"));
		}catch(Exception e) {
		}
		
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		FileConnection fileConnection = gCtx.getBean("fileconnection", FileConnection.class);
		System.out.println("admin ID : " + fileConnection.getAdminId());
		System.out.println("admin PW : " + fileConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();
	}

}
