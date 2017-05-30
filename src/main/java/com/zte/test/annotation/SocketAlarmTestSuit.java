package com.zte.test.annotation;

 /**
 * SocketAlarmTestSuit.java
 * 2017年3月26日下午3:55:37
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
