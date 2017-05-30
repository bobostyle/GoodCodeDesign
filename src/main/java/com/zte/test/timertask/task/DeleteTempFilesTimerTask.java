package com.zte.test.timertask.task;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TimerTask.java
 * 2017��5��31������12:41:26
 * @author cbb
 * TODO //�Զ��嶨ʱ����
 */
public class DeleteTempFilesTimerTask {
	
	private static DeleteTempFilesTimerTask instance = new DeleteTempFilesTimerTask();
	private Timer timer;
	private Date firstDateTime;
	private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;  //һ��Ϊһ������
	private DeleteTempFilesTimerTask(){
		timer = new Timer();
		firstDateTime = initalTimer();
	}
	
	private Date initalTimer(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 1);
		calendar.set(Calendar.MINUTE, 5);
		calendar.set(Calendar.SECOND, 0);	
		Date date = calendar.getTime(); 
		return date;
	}
	public static DeleteTempFilesTimerTask getInstance(){
		return instance;
	}
	public void startTimerTask(){
		timer.scheduleAtFixedRate(new DeleteFileTask(), firstDateTime, PERIOD_DAY);
	}
	
	private class DeleteFileTask extends TimerTask{
		@Override
		public void run() {
			FileUtil.deleteSepcifyConditionFile(FileUtil.getResourcePath());
		}
	}
	
	
	
	public static void main(String[] args) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				DeleteTempFilesTimerTask.getInstance().startTimerTask();
				while(true){
				}
			}}).start();

	}
}
