package com.zte.test.timertask.task;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * FileUtil.java
 * 2017年4月13日上午12:11:20
 * @author cbb
 * TODO 
 */
public class FileUtil {
	
	private final static String WORK_DIRECTORY = System.getProperty("user.dir");
	public static String getResourcePath(){
		return WORK_DIRECTORY + File.separator + "src" + File.separator + "main" +
				File.separator + "java" + File.separator + "com" + File.separator +
				"zte" + File.separator + "test" + File.separator + "timertask" + File.separator
				+ "resource";
	}
	
	/*
	 * 获取指定路径下所有的文件，递归
	 */
	public static List<File> getAllFiles(String path){
		List<File> files = new ArrayList<File>();
		File file = new File(path);
		File[] subFiles = file.listFiles();
		files = Arrays.asList(subFiles);
		return files;
	}
	/*
	 * delete()指出，如果文件夹不为空的时候，调用delete()会删除失败
	 */
	public static void deleteSepcifyConditionFile(String path){
		List<File> files =  getAllFiles(path);
		for(File file : files){
			String fileName = file.getName();
			if(Long.valueOf(fileName).longValue() <= getPrevoiusDay()){
				deleteFile(file);
			}
		}
	}
	//删除某文件夹及其下的所有文件
	public static void deleteFile(File file){
		if(file.isFile()){ //判断传入的是文件
			file.delete();
		}else{
			File[] files = file.listFiles();
			for(File childFile : files){
				deleteFile(childFile);
			}
			file.delete();
		}
	}
	
	//往前一天
	private static long getPrevoiusDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date date = calendar.getTime();
		String regex = "yyyyMMdd";
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(regex);
	    String currentTime = simpleDateFormat.format( date);
		return Long.valueOf(currentTime).longValue();
	}
	
	public static void main(String[] args) {
		System.out.println(getPrevoiusDay());
	}
}
