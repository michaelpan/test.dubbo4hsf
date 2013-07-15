package com.mitch3.test.dubbo4hsf.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {
	public static void main(String[] args) throws Exception{
		
		String config = "applicationContext.xml";
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
		context.start();
		System.out.println("Started.");
		System.in.read();
	}

}
