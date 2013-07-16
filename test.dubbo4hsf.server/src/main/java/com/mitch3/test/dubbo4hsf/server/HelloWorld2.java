package com.mitch3.test.dubbo4hsf.server;

import com.mitch3.test.dubbo4hsf.api.IHelloWorld2;

public class HelloWorld2 implements IHelloWorld2{

	@Override
	public String hello(String name) {
		return "Hello World2, " + name + "!";
	}

}
