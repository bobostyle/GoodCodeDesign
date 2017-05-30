package com.zte.test.springaop.proxy.dynamiproxy;

 /**
 * AnimalImpl.java
 * 2017年5月28日下午3:47:53
 * @author cbb
 * TODO
 */
public class AnimalImpl implements Animal{

	@Override
	public void animalSleep() {
		System.out.println("animal sleep");
	}

	@Override
	public void animalEet() {
		System.out.println("animal eat");
	}
}
