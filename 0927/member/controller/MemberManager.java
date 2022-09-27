package member.controller;

import member.model.vo.Member;

public class MemberManager {
	
	private static final int MAX_MEMBER = 40;
	Member[] members = new Member[MAX_MEMBER];
	public int index = 0;
	
	// 회원 정보 입력
	public void insertMember(Member m) {
		members[index++] = m; 
	}
	
	// 출력
	public void printData() {
		System.out.println("-----------<<회원정보>>-----------");
		System.out.printf("이름\t등급\t포인트\t이자포인트\n");
		System.out.println("-------------------------------");
		for(int i = 0; i < index; i++)
			System.out.println(members[i].memberInfo());
	}
}
