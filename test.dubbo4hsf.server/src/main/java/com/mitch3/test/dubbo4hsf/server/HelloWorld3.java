package com.mitch3.test.dubbo4hsf.server;

import com.mitch3.test.dubbo4hsf.api.IHelloWorld3;

public class HelloWorld3 implements IHelloWorld3{

	@Override
	public String hello(String name) {
		return "Hello World3, " + name + "!";
	}

}
