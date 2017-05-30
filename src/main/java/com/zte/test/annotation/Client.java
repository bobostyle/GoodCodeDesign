package com.zte.test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Client.java
 * 2017年3月23日下午11:38:25
 * @author cbb
 * TODO
 */
public class Client {
	
	public static void getSelfDefineAnnotation(){
		
		Class<CorbaAlarmSyncTestCase> clazz = CorbaAlarmSyncTestCase.class;
		System.out.println(clazz.getAnnotation(MyTest.class));
		Annotation[] annotations = clazz.getAnnotations();
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods){
			Annotation[] methodannotations = method.getAnnotations();
			for(Annotation methodan : methodannotations){
				System.out.println(methodan.annotationType().getName());
			}
		}
		System.out.println(annotations.length);
		for(Annotation annotation : annotations){
			System.out.println(annotation.annotationType().getName());
		}
	}
	
	public static void main(String[] args) {
	 //	getAllAnnotation();
	 // getSelfDefineAnnotation();
	}
}
