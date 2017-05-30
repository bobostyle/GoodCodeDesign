package com.zte.test.springaop.proxy.reflect;

 /**
 * ReflectMethod.java
 * 2017年3月26日下午5:31:57
 * @author cbb
 * TODO
 */
public class ReflectMethod {
	
	private final String VALUE = "come on";
	
	public int getName(String key){
		String temp = key + VALUE; 
		return 1;
	}
	
	public void getAddress(String key){
		System.out.println(key);
	}
	
	public void test(){
		System.out.println("has no output value");
	}
	
}
