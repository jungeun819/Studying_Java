package com.sh.oop.method.static_;

public class Run {

	public static void main(String[] args) {
		StaticMethod st = new StaticMethod();
		
		System.out.println(StaticMethod.toupper("kh academy"));
		System.out.println(StaticMethod.setChar("java", 0, 'x'));
		System.out.println(StaticMethod.getAlphabetLength("์๋, ๋ James์ผ!"));
		System.out.println(st.concat("hello","world"));
		
	}

}
