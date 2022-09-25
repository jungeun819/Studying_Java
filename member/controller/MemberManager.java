package member.controller;

import member.model.vo.Gold;
import member.model.vo.Sliver;
import member.model.vo.Vip;
import member.model.vo.Vvip;

public class MemberManager {
	public static final int MAX_PERSON = 10;
	
	// sliver
	private Sliver[] slivers = new Sliver[MAX_PERSON];
	private int sIndex = 0; // 등급별로 회원수가 다를 수 있으므로 각각 인덱스 설정
	public void silverInsert(Sliver sliver) {
		slivers[sIndex++] = sliver;
	}
	// gold
	private Gold[] golds = new Gold[MAX_PERSON];
	private int gIndex = 0;
	public void goldInsert(Gold gold) {
		golds[gIndex++] = gold;
	}
	
	// vip
	private Vip[] vips = new Vip[MAX_PERSON];
	private int vIndex = 0;
	public void vipInsert(Vip vip) {
		vips[vIndex++] = vip;
	}
	
	// vvip
	private Vvip[] vvips = new Vvip[MAX_PERSON];
	private int vvIndex = 0;
	public void vvipInsert(Vvip vvip) {
		vvips[vvIndex++] = vvip;
	}
	
	// 출력
	public void printData() {
		System.out.println("-----------<<회원정보>>-----------");
		System.out.printf("이름\t등급\t포인트\t이자포인트\n");
		System.out.println("-------------------------------");
		for(int i = 0; i < sIndex; i++) 
			System.out.println(slivers[i].sliverInfo());
		for(int i = 0; i < gIndex; i++)
			System.out.println(golds[i].goldInfo());
		for(int i = 0; i < vIndex; i++)
			System.out.println(vips[i].vipInfo());
		for(int i = 0; i < vvIndex; i++)
			System.out.println(vvips[i].vvipInfo());
	}
}
