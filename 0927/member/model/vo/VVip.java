package member.model.vo;

public class VVip extends Member{
	
	// 생성자
	public VVip() {}
	public VVip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	@Override
	public double getEjaPoint() {
		return (int)(this.getPoint() * 0.15);
	}
}
