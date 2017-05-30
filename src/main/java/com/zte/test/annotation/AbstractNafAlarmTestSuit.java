package com.zte.test.annotation;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * AbstractSuit.java
 * 2017��3��26������2:08:40
 * @author cbb
 * TODO
 */
public class AbstractNafAlarmTestSuit {
	
	private String testSuitId;
	public AbstractNafAlarmTestSuit(String id){
		this.testSuitId = id;
	}
	public String getSuitId(){
		return testSuitId;
	}
	
	private List<AbstractNafAlarmTestCase> alarmTestCases = new ArrayList<AbstractNafAlarmTestCase>();
	public  List<AbstractNafAlarmTestCase> getAllAlarmTestCase(){
		return alarmTestCases;
	}
	//��ȡ���в��Լ���صĲ�������
	public void getAllTestCases() throws InstantiationException, IllegalAccessException{
		TestCase annotation = this.getClass().getAnnotation(TestCase.class);
		Class<?>[] clazzs = annotation.clazz();
		for(Class<?> clazz : clazzs){
			alarmTestCases.add((AbstractNafAlarmTestCase)clazz.newInstance());
		}
		showAllTestCaseName();
	}
	
	private void showAllTestCaseName(){
		System.out.println(alarmTestCases.size());
		for(AbstractNafAlarmTestCase testcase : alarmTestCases){
			System.out.println(testcase.getClass().getName());
		}
	}
//	//��ȡ������ĳ��ע�����
//	public Object getClassName(Class<? extends Annotation> annotationtype){
//		if(this.getClass().isAnnotationPresent(annotationtype)){
//			
//		}
//	}
}	
