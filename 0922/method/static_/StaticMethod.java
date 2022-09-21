package com.sh.oop.method.static_;

public class StaticMethod {
	
	public static String toupper(String str){
		String result = "";
		int tmp;
		for(int i = 0; i < str.length(); i++) {
			tmp = (int)str.charAt(i);
			if((97 <= tmp) && (122 >= tmp)) {
				result += (char)(tmp - 32);
			}
			else {
				result += (char)tmp;
				 
			}
		}
		return result;
	}
	// xava 리턴
	public static String setChar(String str, int index, char c) {
		char[] tmp = new char[str.length()];
		String result = "";
		for(int i = 0; i < str.length(); i++) {
			tmp[i] = str.charAt(i);
			tmp[index] = c;
			result += tmp[i];
		}
		return result;
	}
		
	// 5 리턴
	public static int getAlphabetLength(String str) {
		char tmp; 
		int cnt = 0;
		
		for(int i = 0; i < str.length(); i++) {
			tmp = str.charAt(i);
			if(('A'<= tmp && 'Z' >= tmp) || ('a' <= tmp && 'z' >= tmp)) 
				++cnt;
			
		}
		return cnt;
	}
	// "helloworld" 리턴
	public String concat(String str1, String str2) {
		return str1 + str2;
		
		
	}
}
