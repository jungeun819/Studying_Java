package member.model.vo;

public class Vip extends Member {
	
	// 생성자
	public Vip() {}
	public Vip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	@Override
	public double getEjaPoint() {
		return this.getPoint() * 0.1;
	}
}
