package com.mitch3.test.dubbo4hsf.server;

import com.mitch3.test.dubbo4hsf.api.IHelloWorld1;

public class HelloWorld1 implements IHelloWorld1{

	@Override
	public String hello(String name) {
		return "Hello World1, " + name + "!";
	}

}
