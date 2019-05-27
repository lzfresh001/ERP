package com.lzf.authority.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lzf.authority.service.LoginService;
import com.lzf.authority.vo.UserInfo;

public class LoginTest {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		LoginService ls = (LoginService)ac.getBean("loginService");
		//boolean isUser = ls.isRightUser("admin", "123456");
		//UserInfo user = ls.queryUserInfoByUserCode("admin", "123456");
		//System.out.println(isUser);
	}

}
