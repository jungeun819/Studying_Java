package member.model.vo;

public class Silver extends Member {
	
	// 생성자
	public Silver() {}
	public Silver(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	@Override
	public double getEjaPoint() {
		return this.getPoint() * 0.02;
	}
}
