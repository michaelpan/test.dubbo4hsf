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
			Thread.sleep(3000);
			String dubboResult = dubboBean.hello("dubbo");
			System.out.println(dubboResult);
			
			
			IHelloWorld hsfBean = (IHelloWorld) context.getBean("helloWorld.hsf");
			Thread.sleep(3000);
			String hsfResult = hsfBean.hello("HSF");
			System.out.println(hsfResult);
			
			IHelloWorld dubboHsfBean = (IHelloWorld) context.getBean("helloWorld.dubbo-hsf");
			String dubboHsfResult = dubboHsfBean.hello("Dubbo-HSF");
			System.out.println(dubboHsfResult);
		} finally {
			System.exit(0);
		}
	}
}
