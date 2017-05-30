package com.zte.test.io;

import java.io.UnsupportedEncodingException;

/**
 * EncodeAndDecode.java
 * 2017��4��12������10:23:03
 * @author cbb
 * TODO ���ڴ��н��б���ͽ��� 
 */
public class StringEncodeAndDecode {
	
	//String ��
	public static void stringEncode(String charsetName) throws UnsupportedEncodingException{
		String value = "I am ��ɽ";   
		byte[] bytes = value.getBytes(charsetName);
		System.out.println(bytes.length);
		for(byte by : bytes){
			System.out.println(Integer.toHexString(by));
		}
	}
	
	//��Integer�д�������ת��16���ƣ�8���ƣ�2���Ƶġ�
	public static void main(String[] args) throws UnsupportedEncodingException {
		String charsetName = "UTF-8";
		stringEncode(charsetName);
		
		String gbk = "GBK";
		stringEncode(gbk);
	}
}
