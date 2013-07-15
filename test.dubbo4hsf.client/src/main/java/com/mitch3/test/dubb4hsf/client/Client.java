package com.mitch3.test.dubb4hsf.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitch3.test.dubbo4hsf.api.IHelloWorld;

public class Client {

	public static void main(String[] args) throws Exception {
		String config = "applicationContext.xml";
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
		context.start();
		try {
			IHelloWorld dubboBean = (IHelloWorld) context.getBean("helloWorld.dubbo");
			String dubboResult = dubboBean.hello("dubbo");
			System.out.println(dubboResult);
			
			
			IHelloWorld hsfBean = (IHelloWorld) context.getBean("helloWorld.hsf");
			String hsfResult = hsfBean.hello("HSF");
			System.out.println(hsfResult);
		} finally {
			System.exit(0);
		}
	}
}
