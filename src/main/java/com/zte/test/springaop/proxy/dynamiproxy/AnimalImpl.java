package com.zte.test.springaop.proxy.dynamiproxy;

 /**
 * AnimalImpl.java
 * 2017��5��28������3:47:53
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
