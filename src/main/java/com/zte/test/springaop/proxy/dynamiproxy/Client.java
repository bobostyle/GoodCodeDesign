package com.zte.test.springaop.proxy.dynamiproxy;

 /**
 * Client.java
 * 2017��5��28������3:17:07
 * @author cbb
 * TODO
 */
public class Client {
	
	public static void main(String[] args) {
		
		HumanImplFactory.getInstance().eat();
		HumanImplFactory.getInstance().sleep();
		
		AnimalImplFactory.getInstance().animalEet();
		AnimalImplFactory.getInstance().animalSleep();
	}
}
