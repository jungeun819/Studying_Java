package member.run;

import member.controller.MemberManager;
import member.model.vo.Gold;
import member.model.vo.Sliver;
import member.model.vo.Vip;
import member.model.vo.Vvip;

public class Run {

	public static void main(String[] args){
		MemberManager m = new MemberManager();
		m.silverInsert(new Sliver("홍길동", "Silver",1000));
		m.silverInsert(new Sliver("김말똥", "Silver",2000));
		m.silverInsert(new Sliver("고길동", "Silver",3000));
		m.goldInsert(new Gold("김회장", "Gold",1000));
		m.goldInsert(new Gold("이회장", "Gold",2000));
		m.goldInsert(new Gold("오회장", "Gold",3000));
		m.vipInsert(new Vip("이부자", "Vip",10000));
		m.vvipInsert(new Vvip("김갑부", "VVip",100000));
		m.printData();
	}

}
