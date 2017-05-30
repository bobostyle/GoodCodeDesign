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
 * 2017��4��13������12:11:20
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
	 * ��ȡָ��·�������е��ļ����ݹ�
	 */
	public static List<File> getAllFiles(String path){
		List<File> files = new ArrayList<File>();
		File file = new File(path);
		File[] subFiles = file.listFiles();
		files = Arrays.asList(subFiles);
		return files;
	}
	/*
	 * delete()ָ��������ļ��в�Ϊ�յ�ʱ�򣬵���delete()��ɾ��ʧ��
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
	//ɾ��ĳ�ļ��м����µ������ļ�
	public static void deleteFile(File file){
		if(file.isFile()){ //�жϴ�������ļ�
			file.delete();
		}else{
			File[] files = file.listFiles();
			for(File childFile : files){
				deleteFile(childFile);
			}
			file.delete();
		}
	}
	
	//��ǰһ��
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
