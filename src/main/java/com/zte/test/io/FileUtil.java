package com.zte.test.io;

import java.io.File;

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
				"zte" + File.separator + "test" + File.separator + "io" + File.separator
				+ "resource";
	}
	
	public static String getInputFilePath(){
		return getResourcePath() + File.separator + "input";
	}
	
	public static String getOutputFilePath(){
		return getResourcePath() + File.separator + "output";
	}
	
	public static void main(String[] args) {
		System.out.println(getResourcePath());
	}
}
