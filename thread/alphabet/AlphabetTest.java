package com.thread.alphabet;

import java.util.Scanner;

public class AlphabetTest {

	public static void main(String[] args) {
		Thread upThread = new Thread(new UpperAlphbetThread(), "알파벳 대문자");
		Thread lowThread = new Thread(new LowerAlphbetThread(), "알파벳 소문자");
		
		upThread.start();
		lowThread.start();
		
		System.out.println("실행취소 : enter");
		new Scanner(System.in).nextLine();
		upThread.interrupt();
		lowThread.interrupt();
	}
}
