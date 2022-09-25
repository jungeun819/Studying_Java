package member.model.vo;

public class Vvip {
	
	private String name;
	private String grade;
	private int point;
	private double bonusPoint;
	
	// 생성자
	public Vvip() {}
	public Vvip(String name, String grade, int point) {
		this.name = name;
		this.grade = grade;
		this.point = point;
	}
	
	// vvip 회원정보
	public String vvipInfo() {
		bonusPoint = point * 0.15;
		return name + "\t" + grade + "\t" + point + "\t" + String.format("%.2f", bonusPoint);
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
	public double getBonusPoint() {
		return this.bonusPoint;
	}
	
	

}
