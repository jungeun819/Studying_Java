package com.sh.oop.emp.run;

import java.util.Scanner;

import com.sh.oop.emp.model.Employee;

public class EmpTest {
	
	public static void main(String[] args) {
		Employee employee = new Employee();
		EmpTest emp = new EmpTest();
		
		do {
			emp.mainMenu();
			Scanner sc = new Scanner(System.in);
			System.out.print("원하는 번호를 입력해 주세요 : ");
			String choice = sc.next();
			
			// 원하는 작업 선택
			switch(choice) {
			case "1" : employee.emInput(); break;
			
			case "2" : employee.setEmpNo(0);
					   employee.setEmpName(null);
					   employee.setDept(null);
					   employee.setJob(null);
					   employee.setAge(0);
					   employee.setGender(' ');
					   employee.setSalary(0);
					   employee.setBonusPoint(0);
					   employee.setPhone(null);
					   employee.setAddress(null);
					   System.out.println("사원 정보를 삭제하였습니다.");
					   break;
			
			case "3" : employee.empOutput(); break;
			
			case "9" : System.out.println("시스템을 종료합니다."); return;
			
			default : System.out.println("잘못 입력하셨습니다."); 
		}
			
			System.out.print("메인 메뉴로 돌아가시겠습니까?(y/n) : ");
			char ch = sc.next().charAt(0);
			if(ch == 'n')
				break;
		
		}while(true);
	}
	
	// 메인메뉴생성
	public void mainMenu() {
		System.out.println("********** 사원 정보 관리 프로그램 **********");
		System.out.println("1. 새 사원 정보 입력");
		System.out.println("2. 사원 정보 삭제");
		System.out.println("3. 사원정보 출력");
		System.out.println("9. 끝내기");
		System.out.println("*************************************");
	}

}
