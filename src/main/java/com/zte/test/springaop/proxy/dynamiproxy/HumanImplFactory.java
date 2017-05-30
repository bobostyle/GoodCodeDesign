package com.zte.test.springaop.proxy.dynamiproxy;

 /**
 * Factory.java
 * 2017年5月28日下午3:23:04
 * @author cbb
 * TODO 代理类和代理的结合
 */
public class HumanImplFactory implements Human{
	
	private Human human;
	private Human humanProxy;
	private static HumanImplFactory instance = new HumanImplFactory();
	private HumanImplFactory(){
		human = new HumanImpl();
		DynamicProxy proxy = new DynamicProxy(human);
		humanProxy = proxy.getProxyInstance();
	}
	public static HumanImplFactory getInstance(){
		return instance;
	}
	
	@Override
	public void sleep() {
		humanProxy.sleep();
	}

	@Override
	public void eat() {
		humanProxy.eat();
	}
}
