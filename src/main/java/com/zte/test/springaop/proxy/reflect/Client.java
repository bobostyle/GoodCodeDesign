package com.zte.test.springaop.proxy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Client.java
 * 2017��3��26������5:36:48
 * @author cbb 
 * TODO ʹ�÷������˽�з���
 */
public class Client {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ReflectMethod reflectObject = new ReflectMethod();
		Method method = reflectObject.getClass().getMethod("getName", String.class);
		Object result = method.invoke(reflectObject, "Chen biao biao");
		System.out.println(result);
		
		Method method2 = reflectObject.getClass().getMethod("getAddress", String.class);
		method2.invoke(reflectObject, "hello"); //���û�з���ֵ����ôinvoke�ķ���ֵΪnull
		
		Method method3 = reflectObject.getClass().getMethod("test"); //������õķ���û���βΣ���ôgetMethod��������Ҫ��2������
		method3.invoke(reflectObject);
	}
}
