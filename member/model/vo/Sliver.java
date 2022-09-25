package member.model.vo;

public class Sliver {
	
	private String name;
	private String grade;
	private int point;
	private double bonusPoint;
	
	// 생성자
	public Sliver() {}
	public Sliver(String name, String grade, int point) {
		this.name = name;
		this.grade = grade;
		this.point = point;
	}
	// sliver 회원 정보
	public String sliverInfo() {
		bonusPoint = point * 0.02;
		return name + "\t" + grade + "\t" + point + "\t" + String.format("%.2f", bonusPoint);
				
	}
	
	// getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getBonusPoint() {
		return this.bonusPoint;
	}
	
	
}
