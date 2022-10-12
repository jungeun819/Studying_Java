package com.thread.sleep;

import java.util.Scanner;

public class SleepTest {

	public static void main(String[] args) {
		SleepTest t = new SleepTest();
		t.sendAphorism();
	}
	
	public void sendAphorism() {
		
		String[] arr = {
				"말 한마디에 천냥 빛도 갚는다.",
				"낮말은 새가 듣고, 밤 말은 쥐가 듣는다.",
				"고슴도치도 친구가 있다.",
				"얌전한 고양이 부뚜막에 먼저 올라간다.",
				"남의 떡이 더 커보인다.",
				"누워서 떡 먹기",
				"돌다리도 두들겨 보고 건너라",
				"등잔밑이 어둡다.",
				"믿는 도끼에 발등 찍힌다.",
				"벼는 익을수록 고개를 숙인다."
				};
		
		Thread th = new Thread(new SleepThread(arr), "속담");
		th.start();
		
		System.out.println("실행취소 : enter");
		new Scanner(System.in).nextLine();
		th.interrupt();
	}
	
	class SleepThread implements Runnable{
		private String[] str;
		
		public SleepThread(String[] str) {
			this.str = str;
		}

		@Override
		public void run() {
			int i = 0;
			while(i++ < str.length) {
				try {
					Thread.sleep(3000); // 3초 지연
				} catch (InterruptedException e) {
					break;
				}
				int rnd = (int)(Math.random() * str.length); // 0 ~ 10 중 랜덤한 숫자 입력
				System.out.println("[" + i + "]" + str[rnd]);
			}
			System.out.println(Thread.currentThread().getName() + " End!");
		}
		
	}

}
