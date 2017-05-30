package com.zte.test.timertask.test;

import java.io.File;
import java.util.List;
import org.junit.Test;

import com.zte.test.timertask.task.DeleteTempFilesTimerTask;
import com.zte.test.timertask.task.FileUtil;

/**
 * FileUtilTest.java
 * 2017年5月30日下午11:14:16
 * @author cbb
 * TODO
 */
public class FileUtilTest {
	private String path = FileUtil.getResourcePath(); 
	@Test
	public void test_get_all_files(){
		List<File> files = FileUtil.getAllFiles(path);
		for(File file : files){
			System.out.println(file.getName());
		}
	}
	
	@Test
	public void test_delete_file(){
		FileUtil.deleteSepcifyConditionFile(path);
	}
	
	@Test
	public void test_timer_task(){
		new Thread(new Runnable(){
			@Override
			public void run() {
				DeleteTempFilesTimerTask.getInstance().startTimerTask();
				while(true){
				}
			}}).start();
	}
}
