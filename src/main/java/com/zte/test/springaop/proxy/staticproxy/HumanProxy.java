package com.zte.test.springaop.proxy.staticproxy;

 /**
 * HumanProxy.java
 * 2017年3月26日下午4:19:47
 * @author cbb
 * TODO
 */
public class HumanProxy implements Human{
	private Human human;
	public HumanProxy(Human human){
		this.human = human;
	}
	public void eat() {
		before();
		human.eat();
		after();
	}
	
	private void before(){
		System.out.println("go home");
	}
	
	private void after(){
		System.out.println("swep");
	}
}
