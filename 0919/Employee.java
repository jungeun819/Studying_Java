package com.sh.oop.emp.model;

import java.util.Scanner;

public class Employee {
	
	// 필드 작성
	private int empNo, age, salary;
	private double bonusPoint;
	private char gender;
	private String empName, dept, job, phone, address;
	
	// 사번
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getEmpNo() {
		return this.empNo;
	}
	// 이름
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpName() {
		return this.empName;
	}
	// 소속부서
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDept() {
		return this.dept;
	}
	// 직급
	public void setJob(String job) {
		this.job = job;
	}
	public String getJob() {
		return this.job;
	}
	// 나이
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	// 성별
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return this.gender;
	}
	// 급여
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getSalary() {
		return this.salary;
	}
	// 보너스포인트
	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getBonusPoint() {
		return this.bonusPoint;
	}
	// 핸드폰
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return this.phone;
	}
	// 주소
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}
	
	// 사원정보입력 메소드
	public void emInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----새 사원 정보 입력-----");
		
		System.out.print("사번 : ");
		int empNo = sc.nextInt();
		setEmpNo(empNo);
		
		System.out.print("이름 : ");
		String empName = sc.next();
		setEmpName(empName);
		
		System.out.print("소속부서 : ");
		String dept = sc.next();
		setDept(dept);
		
		System.out.print("직급 : ");
		String job = sc.next();
		setJob(job);
		
		System.out.print("나이 : ");
		int Age = sc.nextInt();
		setAge(Age);
		
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		setGender(gender);
		
		System.out.print("급여 : ");
		int salary = sc.nextInt();
		setSalary(salary);
		
		System.out.print("보너스 포인트 : ");
		double bonusPoint = sc.nextDouble();
		setBonusPoint(bonusPoint);
		
		System.out.print("핸드폰 : ");
		String phone = sc.next();
		setPhone(phone);
		
		System.out.print("주소 : ");
		String address = sc.next();
		setAddress(address);
		
		System.out.println("-----사원 정보를 저장하였습니다.-----");
		System.out.println();
	}
	
	// 사원정보출력 메소드
	public void empOutput() {
		System.out.println("사번 : " + getEmpNo());
		System.out.println("이름 : " + getEmpName());
		System.out.println("소속부서 : " + getDept());
		System.out.println("직급 : " + getJob());
		System.out.println("나이 : " + getAge());
		System.out.println("성별 : " + getGender());
		System.out.println("급여 : " + getSalary());
		System.out.println("보너스포인트 : " + getBonusPoint());
		System.out.println("핸드폰 : " + getPhone());
		System.out.println("주소 : " + getAddress());
	}	

}
