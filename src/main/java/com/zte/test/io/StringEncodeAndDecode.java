package com.zte.test.io;

import java.io.UnsupportedEncodingException;

/**
 * EncodeAndDecode.java
 * 2017年4月12日下午10:23:03
 * @author cbb
 * TODO 在内存中进行编码和解码 
 */
public class StringEncodeAndDecode {
	
	//String 类
	public static void stringEncode(String charsetName) throws UnsupportedEncodingException{
		String value = "I am 君山";   
		byte[] bytes = value.getBytes(charsetName);
		System.out.println(bytes.length);
		for(byte by : bytes){
			System.out.println(Integer.toHexString(by));
		}
	}
	
	//在Integer中存在整数转成16进制，8进制，2进制的。
	public static void main(String[] args) throws UnsupportedEncodingException {
		String charsetName = "UTF-8";
		stringEncode(charsetName);
		
		String gbk = "GBK";
		stringEncode(gbk);
	}
}
