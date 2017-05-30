package com.zte.test.springaop.proxy.staticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * PerformanceProxy.java
 * 2017年3月26日下午4:49:28
 * @author cbb
 * TODO 性能监控代理
 */ 
public class PerformanceProxy implements InvocationHandler{
	private Object target;
	public PerformanceProxy(Object target){
		this.target = target;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		startTime();
		Object result = method.invoke(target, args);
		endTime();
		System.out.println(costTime());
		return result; 
	}
	
	private Long startTime(){
		return System.currentTimeMillis();
	}
	
	private Long endTime(){
		return System.currentTimeMillis();
	}
	
	
	
	private Long costTime(){
		return endTime() - startTime();
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Object> T getDynamicalProxyInstance(){
		return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
	}
}
