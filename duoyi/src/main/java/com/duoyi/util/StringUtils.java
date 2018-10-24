package com.duoyi.util;

import java.util.Random;

public class StringUtils {

	public static String getRandomString(int length){
	    //定义一个字符串（A-Z，a-z，0-9）即62位；
	    String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
	    //由Random生成随机数
	        Random random=new Random();  
	        StringBuffer sb=new StringBuffer();
	        //长度为几就循环几次
	        for(int i=0; i<length; ++i){
	          //产生0-61的数字
	          int number=random.nextInt(62);
	          //将产生的数字通过length次承载到sb中
	          sb.append(str.charAt(number));
	        }
	        //将承载的字符转换成字符串
	        return sb.toString();
	  }
	
	public static String splitByPot(String string) {

		String result = null;
		String[] a = string.split("\\.");
		result = a[a.length - 1];
		return result;
	}
	
	//字符串判别空认定
	public static boolean isEmpty(String s){
		if(s == null || "".equals(s)){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
//		System.out.println(getRandomString(30));
		System.out.println(splitByPot("1.txt"));
	}
}
