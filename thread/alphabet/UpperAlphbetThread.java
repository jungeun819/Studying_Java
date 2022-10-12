package com.thread.alphabet;

public class UpperAlphbetThread implements Runnable {

	@Override
	public void run() {
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
			System.out.printf("[대문자] %s\n", ch);
		}
		System.out.println(Thread.currentThread().getName() + " End!");
	}
}
