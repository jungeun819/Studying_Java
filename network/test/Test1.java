package net.network.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 호스트명 or 도메인명 입력받음       -> 둘의 차이가 뭐람,,, www 차이인가..?
		System.out.print("검색할 IP주소의 호스트명 또는 도메인명을 입력해주세요 >> ");
		String search = sc.nextLine();
		
		try {
			// 입력받은 도메인명의 IP 주소 조회
			InetAddress[] hostName = InetAddress.getAllByName(search); // 모든 IP주소 가져오기
			for(InetAddress host : hostName) {
				System.out.println("호스트명 : " + host.getHostName());
				System.out.println("IP 주소 : " + host.getHostAddress() );
			}
		} catch (UnknownHostException e) {
			System.err.printf("입력하신 [%s]을 찾을 수 없습니다.", search);
		}
	}
}
