package com.zte.test.springaop.proxy.dynamiproxy;

 /**
 * AnimalImplFactory.java
 * 2017年5月28日下午3:50:01
 * @author cbb
 * TODO
 */
public class AnimalImplFactory implements Animal{
	
	private Animal animal;
	private Animal animalProxy;
	private static AnimalImplFactory instance = new AnimalImplFactory();
	private AnimalImplFactory(){
		animal = new AnimalImpl();
		DynamicProxy proxy = new DynamicProxy(animal);
		animalProxy = proxy.getProxyInstance();
	}
	public static AnimalImplFactory getInstance(){
		return instance;
	}
	
	@Override
	public void animalSleep() {
		animalProxy.animalSleep();
	}
	
	@Override
	public void animalEet() {
		animalProxy.animalEet();
	}
}
