package member.model.vo;

public class Member {
	
	// field 생성
	protected String name;
	protected String grade;
	protected int point;
	
	// 생성자
	public Member() {}
	public Member(String name, String grade, int point) {
		this.name = name;
		this.grade = grade;
		this.point = point;
	}

	// 회원정보
	public String memberInfo() {
		return name + "\t" + grade + "\t" + point + "\t" + String.format("%.2f", getEjaPoint());
	}
	
	// 이자포인트
	public double getEjaPoint() {
		return this.getEjaPoint();
	}
	
	// getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
