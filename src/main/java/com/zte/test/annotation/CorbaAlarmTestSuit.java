package com.zte.test.annotation;

 /**
 * TestSuit.java
 * 2017��3��23������11:31:22
 * @author cbb
 * TODO
 */
@TestCase(clazz={CorbaAlarmClearTestCase.class, CorbaAlarmReportTestCase.class, CorbaAlarmSyncTestCase.class})
public class CorbaAlarmTestSuit extends AbstractNafAlarmTestSuit{
	public CorbaAlarmTestSuit(){
		super("CorbaNafAlarm-01");
	}
		
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		CorbaAlarmTestSuit nafSuit = new CorbaAlarmTestSuit(); //ִ������Ĺ��캯����ǰ������ִ�и���
		System.out.println(nafSuit.getSuitId());
		nafSuit.getAllTestCases();
	}
}
