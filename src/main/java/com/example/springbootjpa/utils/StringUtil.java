package com.example.springbootjpa.utils;

public class StringUtil {
	public static boolean isNotBlank(String text) {		
		return text!=null&&!text.isEmpty()?true:false;
	}

}
