package com.zte.test.annotation;
 /**
 * CorbaAlarmTest.java
 * 2017��3��23������11:26:06
 * @author cbb
 * TODO
 */
public class CorbaAlarmSyncTestCase extends AbstractNafAlarmTestCase{
	@Override
	public void setUp() {
	}
	
	@MyTest
	public void corbaAlarmTest(){
		System.out.println("my test annotation");
	}
}
