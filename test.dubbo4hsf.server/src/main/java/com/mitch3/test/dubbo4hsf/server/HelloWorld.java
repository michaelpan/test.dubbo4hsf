package com.mitch3.test.dubbo4hsf.server;

import com.mitch3.test.dubbo4hsf.api.IHelloWorld;

public class HelloWorld implements IHelloWorld{

	@Override
	public String hello(String name) {
		return "Hello, " + name + "!";
	}

}
