package com.zte.test.annotation;

 /**
 * TestSuit.java
 * 2017年3月23日下午11:31:22
 * @author cbb
 * TODO
 */
@TestCase(clazz={CorbaAlarmClearTestCase.class, CorbaAlarmReportTestCase.class, CorbaAlarmSyncTestCase.class})
public class CorbaAlarmTestSuit extends AbstractNafAlarmTestSuit{
	public CorbaAlarmTestSuit(){
		super("CorbaNafAlarm-01");
	}
		
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		CorbaAlarmTestSuit nafSuit = new CorbaAlarmTestSuit(); //执行子类的构造函数的前，会先执行父类
		System.out.println(nafSuit.getSuitId());
		nafSuit.getAllTestCases();
	}
}
