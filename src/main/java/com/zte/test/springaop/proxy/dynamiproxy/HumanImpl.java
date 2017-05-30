package com.zte.test.springaop.proxy.dynamiproxy;

 /**
 * HumanImpl.java
 * 2017年5月28日下午3:04:36
 * @author cbb
 * TODO
 */
public class HumanImpl implements Human{
	@Override
	public void eat(){
		System.out.println("eat");
	}
	
	@Override
	public void sleep() {
		System.out.println("sleep");
	}
}
