package com.mitch3.test.dubb4hsf.client;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitch3.test.dubbo4hsf.api.IHelloWorld1;
import com.mitch3.test.dubbo4hsf.api.IHelloWorld2;
import com.mitch3.test.dubbo4hsf.api.IHelloWorld3;
import com.taobao.hsf.exception.HSFServiceAddressNotFoundException;

public class TestClient extends TestCase{
	

//	public static void main(String[] args) throws Exception {
//		
//		String config = "applicationContext.xml";
//		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
//		context.start();
//		try {
//			IHelloWorld dubboBean = (IHelloWorld) context.getBean("helloWorld.dubbo");
//			Thread.sleep(3000);
//			String dubboResult = dubboBean.hello("dubbo");
//			System.out.println(dubboResult);
//			
//			
//			IHelloWorld hsfBean = (IHelloWorld) context.getBean("helloWorld.hsf");
//			Thread.sleep(3000);
//			String hsfResult = hsfBean.hello("HSF");
//			System.out.println(hsfResult);
//			
//			IHelloWorld dubboHsfBean = (IHelloWorld) context.getBean("helloWorld.dubbo-hsf");
//			String dubboHsfResult = dubboHsfBean.hello("Dubbo-HSF");
//			System.out.println(dubboHsfResult);
//			
//			IHelloWorld hsf4dubboBean = (IHelloWorld) context.getBean("helloWorld.hsf4dubbo");
//			String hsf4dubboResult = hsf4dubboBean.hello("HSF4Dubbo");
//			System.out.println(hsf4dubboResult);
//			
//			IHelloWorld dubbo4hsfBean = (IHelloWorld) context.getBean("helloWorld.dubbo4hsf");
//			String dubbo4hsfResult = dubbo4hsfBean.hello("Dubbo4HSF");
//			System.out.println(dubbo4hsfResult);
//		} catch (Exception ex) {
//			logger.error("error", ex);
//			
//		} finally {
//			System.exit(0);
//		}
//	}
	
	/**
	 * 测试以HSFSpringConsumerBean的配置方式访问以Dubbo方式发布的服务
	 */
	public void testHSF4DubboWrong() throws Exception {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext-hsf4dubbo-wrong.xml");
		context.start();
		try {
			IHelloWorld1 bean = (IHelloWorld1) context.getBean("helloWorld.hsf4dubbo");
			Thread.sleep(1000);
			bean.hello("HSF4Dubbo");
			fail("混和调用结果与预期不符");
		} catch (Exception ex) {
			assertTrue(ex.getCause() instanceof HSFServiceAddressNotFoundException);
			assertTrue("不能通过<dubbo:service protocol='dubbo'>方式来引用注册在Dubbo ConfigServer中(Group为HSF)的服务", true);
		} finally {
			context.stop();
			context.destroy();
		}
		
	}
	
	/**
	 * 测试以<dubbo:reference protocol="dubbo">的配置方式访问以HSF服务
	 */
	public void testDubbo4HSFWrong() throws Exception {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext-dubbo4HSF-wrong.xml");
		context.start();
		try {
			IHelloWorld2 bean = (IHelloWorld2) context.getBean("helloWorld.dubbo4hsf");
			Thread.sleep(1000);
			bean.hello("Dubbo4HSF");
			fail("混和调用结果与预期不符");
		} catch (Exception ex) {
			assertTrue(ex instanceof HSFServiceAddressNotFoundException);
			assertTrue("不能通过<dubbo:service protocol='dubbo'>方式来引用注册在Dubbo ConfigServer中(Group为HSF)的服务", true);
		} finally {
			context.stop();
			context.destroy();
		}
		
	}
	
	/**
	 * 测试以<dubbo:reference protocol="hsf">的配置方式访问以HSF服务
	 */
	public void testDubbo4HSFRight() throws Exception {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext-dubbo4HSF-right.xml");
		context.start();
		try {
			IHelloWorld3 bean = (IHelloWorld3) context.getBean("helloWorld");
			Thread.sleep(3000);
			assertEquals("Hello World3, Dubbo4HSF!", bean.hello("Dubbo4HSF"));
		} finally {
			context.stop();
			context.destroy();
		}
	}
	
	/**
	 * 测试混合方式
	 * @throws Exception
	 */
	public void testMixed() throws Exception {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext-mixed.xml");
		context.start();
		Thread.sleep(3000);
		
		IHelloWorld1 dubboBean = (IHelloWorld1) context.getBean("helloWorld.dubbo");
		assertEquals("Hello World1, Dubbo!", dubboBean.hello("Dubbo"));
		
		IHelloWorld2 dubbo4hsf1Bean = (IHelloWorld2) context.getBean("helloWorld.dubbo4hsf1");
		assertEquals("Hello World2, Dubbo4hsf!", dubbo4hsf1Bean.hello("Dubbo4hsf"));
		
		IHelloWorld3 dubbo4hsf2Bean = (IHelloWorld3) context.getBean("helloWorld.dubbo4hsf2");
		assertEquals("Hello World3, Dubbo4hsf!", dubbo4hsf2Bean.hello("Dubbo4hsf"));
		
		IHelloWorld2 hsf1Bean = (IHelloWorld2) context.getBean("helloWorld.hsf1");
		assertEquals("Hello World2, HSF!", hsf1Bean.hello("HSF"));
		
		IHelloWorld3 hsf2Bean = (IHelloWorld3) context.getBean("helloWorld.hsf2");
		assertEquals("Hello World3, HSF!", hsf2Bean.hello("HSF"));
		
		context.stop();
		context.destroy();
		
	}
}
