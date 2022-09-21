package com.sh.oop.emp.run;

import java.util.Scanner;

import com.sh.oop.emp.model.Employee;

public class EmpTest {
	// 여러메소드에서 사용할 수 있도록 멤버변수로 선언
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		EmpTest t = new EmpTest();
		t.mainMenu();

	}
	public void mainMenu() {
		Employee e = null; // 참조형변수 기본값
		
		String menu = "******* 사원 정보 관리 프로그램 **********\n" 
					+ "1. 새 사원 정보 입력\n" 
					+ "2. 사원 정보 수정\n" 
					+ "3. 사원 정보 삭제\n" 
					+ "4. 사원정보 출력\n"
					+ "9. 끝내기\n" 
					+ "*************************************\n" 
					+ "선택하세요 =>";

		int selected = 0;
		while (true) {
			System.out.print(menu);
			selected = sc.nextInt();
			switch (selected) {
			case 1:
				e = new Employee();
				e.emInput();
				break;
			case 2:
				modifyMenu(e);
				break;
			case 3:
				// 사원정보삭제는 참조주소값을 삭제한다.
				// 실제 heap영역의 객체 삭제는 garbage collector가 담당.
				e = null;
				System.out.println("사원 정보가 삭제되었습니다.");
				break;
			case 4:
				// 사원정보 미입력시 출력하지 않도록함.
				// NullPointerException 유발
				if (e == null) 
					System.out.println(">>먼저 사원정보를 입력하세요.");
				else 					
					e.empOutput();
				break;
			}
			if (selected == 9)
				break;
		}

	}
	
	/**
	 * 리턴하면 mainMenu의 modifyMenu호출부로 돌아간다.
	 * 
	 * @param e
	 */
	public void modifyMenu(Employee e) {
		String menu = "********** 사원 정보 수정 메뉴 **********\r\n"
					+ "1. 이름 변경 => setEmpName()\r\n"
					+ "2. 급여 변경 => setSalary()\r\n"
					+ "3. 부서 변경 => setDept()\r\n"
					+ "4. 직급 변경 => setJob()\r\n"
					+ "5. 이전 메뉴로 이동 => return 처리할 것";
		
		while(true) {
			System.out.println(menu);
			
			System.out.print("선택하세요 =>");
			String choice = sc.next();
			
			switch(choice) {
			case "1" :
				System.out.print("변경할 이름을 입력해주세요 : ");
				String name = sc.next();
				e.setEmpName(name); 
				System.out.printf("[%s]로 변경되었습니다.\n", name);
				break;
			case "2" : 
				System.out.print("변경할 급여를 입력해주세요 : ");
				int salary = sc.nextInt();
				e.setSalary(salary); 
				System.out.printf("[%d]로 변경되었습니다/n", salary);
				break;
			case "3" :
				System.out.print("변경할 부서를 입력해주세요 : ");
				String dept = sc.next();
				e.setDept(dept);
				System.out.printf("[%s]로 변경되었습니다\n", dept);
				break;
			case "4" :
				System.out.print("변경할 직급을 입력해주세요 : ");
				String job = sc.next();
				e.setJob(job); 
				System.out.printf("[%s]로 변경되었습니다.\n", job);
		
			case "5" :  
				return;
			
				
			}
			
		}
		
		
	}
}