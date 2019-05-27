package com.lzf.css.test;

import java.text.ParseException;
import java.util.Calendar;

public class Test {

	/*public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		StudentService ss = (StudentService)ac.getBean("studentService");
		Student stu = ss.findStuBySid("190101");
		int updateRows = ss.insertElect("190102", 1102);
		System.out.println(updateRows);
	}*/
	
	public static void main(String[] args) throws ParseException {
		
		Calendar c = Calendar.getInstance();
		int d = c.get(Calendar.YEAR);
		System.out.println(d);
		String sbrithday = "2019/3/28";
		String sbir = sbrithday.substring(0, 4);
		System.out.println(sbir);
		int ss = Integer.parseInt(sbir);
		System.out.println(ss);
		
	}
	
}
