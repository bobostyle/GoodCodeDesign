package com.zte.test.springaop.proxy.staticproxy;

import java.lang.reflect.Proxy;

/**
 * Client.java
 * 2017年3月26日下午4:22:59
 * @author cbb
 * TODO
 */
public class Client {
	
	public static void main(String[] args) {
//		CalculateImpl calculate = new CalculateImpl();
//		calculate.calculate();
		
		Calculate calculate = new CalculateImpl();
		PerformanceProxy dynamicalProxy = new PerformanceProxy(calculate);
		Calculate calculateProxy = dynamicalProxy.getDynamicalProxyInstance();
		calculateProxy.calculate();
	}
}
