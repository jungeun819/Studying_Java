package member.model.vo;

public class Sliver extends Member {
	
	// 생성자
	public Sliver() {}
	public Sliver(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	@Override
	public double getEjaPoint() {
		return this.getPoint() * 0.02;
	}
}
