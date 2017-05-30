package com.zte.test.springaop.proxy.dynamiproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * DynamicProxy.java
 * 2017年5月28日下午3:06:07
 * @author cbb
 * TODO 
 */
public class DynamicProxy implements InvocationHandler {
	
	private Object target;
	public DynamicProxy(Object object){
		this.target = object;
	}
	
	//代理模式，对某个接口类进行代理实现。拦截接口中定义的某些方法，如果满足要求做一些处理，否则按照以前的方式处理。
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().contains("sleep")){
			before();
		}
		Object object = method.invoke(target, args); 
		after();
		return object;
	}
	
	private void before(){
		System.out.println("before");
	}
	
	private void after(){
		System.out.println("after");
	}

	@SuppressWarnings("unchecked")
	public <T extends Object> T getProxyInstance(){
		return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
}
