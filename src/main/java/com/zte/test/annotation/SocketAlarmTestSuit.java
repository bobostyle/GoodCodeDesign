package com.zte.test.annotation;

 /**
 * SocketAlarmTestSuit.java
 * 2017��3��26������3:55:37
 * @author cbb
 * TODO
 */
@TestCase(clazz = {SocketAlarmReportTestCase.class, SocketAlarmSyncTestCase.class})
public class SocketAlarmTestSuit extends AbstractNafAlarmTestSuit{
	public SocketAlarmTestSuit() {
		super("SocketNafAlarm-01");
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		SocketAlarmTestSuit nafSuit = new SocketAlarmTestSuit(); 
		System.out.println(nafSuit.getSuitId());
		nafSuit.getAllTestCases();
	}
}
