package com.zte.test.springaop.proxy.dynamiproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * DynamicProxy.java
 * 2017��5��28������3:06:07
 * @author cbb
 * TODO 
 */
public class DynamicProxy implements InvocationHandler {
	
	private Object target;
	public DynamicProxy(Object object){
		this.target = object;
	}
	
	//����ģʽ����ĳ���ӿ�����д���ʵ�֡����ؽӿ��ж����ĳЩ�������������Ҫ����һЩ������������ǰ�ķ�ʽ����
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
