package com.zte.test.springaop.proxy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Client.java
 * 2017年3月26日下午5:36:48
 * @author cbb 
 * TODO 使用反射调用私有方法
 */
public class Client {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ReflectMethod reflectObject = new ReflectMethod();
		Method method = reflectObject.getClass().getMethod("getName", String.class);
		Object result = method.invoke(reflectObject, "Chen biao biao");
		System.out.println(result);
		
		Method method2 = reflectObject.getClass().getMethod("getAddress", String.class);
		method2.invoke(reflectObject, "hello"); //如果没有返回值，那么invoke的返回值为null
		
		Method method3 = reflectObject.getClass().getMethod("test"); //如果调用的方法没有形参，那么getMethod方法不需要第2个参数
		method3.invoke(reflectObject);
	}
}
