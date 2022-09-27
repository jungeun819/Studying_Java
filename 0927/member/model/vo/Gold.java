package member.model.vo;

public class Gold extends Member {
	
	// 생성자 
	public Gold() {}
	public Gold(String name, String grade, int point) {
		super(name, grade, point);
		this.name = name;
	}
	
	@Override
	public double getEjaPoint() {
		return this.getPoint() * 0.05;
	}
}
