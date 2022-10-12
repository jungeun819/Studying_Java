package com.thread.alphabet;

public class LowerAlphbetThread implements Runnable{

	@Override
	public void run() {
		for(char ch = 'a'; ch <= 'z'; ch++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
			System.out.printf("[소문자] %s\n", ch);
		}
		System.out.println(Thread.currentThread().getName() + " End!");
	}
}
