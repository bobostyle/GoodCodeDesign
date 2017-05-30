package com.zte.test.annotation;
 /**
 * CorbaAlarmTest.java
 * 2017年3月23日下午11:26:06
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
