package com.join.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean {
	private Environment env;
	private String adminId;
	private String adminPw;
	
	@Override // EnvironmentAware 를 인플리먼트 하면 무조건 정의해야 
	public void setEnvironment(Environment env){ // 빈이 생성되는 시점 가장 먼저 실
		System.out.println("setEnvironment()");
		setEnv(env); // Environment에 env를 set 해주는 과정
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public Environment getEnv() {
		return env;
	}

	public String getAdminId() {
		return adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		setAdminId(env.getProperty("admin.id")); // env의 프로퍼티에서 가져와 set해주는 과정
		setAdminPw(env.getProperty("admin.pw")); // env가 먼저 생성되어 Environment에 set되어있
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy()");
	}
	
}
