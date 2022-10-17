package slot_machine.view;

import java.util.List;
import java.util.Scanner;

import slot_machine.controller.ProductManager;
import slot_machine.model.vo.Product;

public class MachineMenu {
	
	public ProductManager manager = new ProductManager();
	public Product p = new Product();
	private Scanner sc = new Scanner(System.in);
	
	public void who() {
		String menu = "┌─────────────────────────────┐\n"
			        + "│  ☆☆☆☆☆☆☆  자판기  ☆☆☆☆☆☆☆  　 │\n"
			        + "│                             │\n"
			        + "│  1. 사용자 화면                 │\n"          
			        + "│                             │\n"
			        + "│  2. 관리자 화면                 │\n"
			        + "│                             │\n"
			        + "└─────────────────────────────┘\n"
			        + "♠ 메뉴선택 : " ;
		
		System.out.print(menu);
		String select = sc.next();
		
		while(true) {
			switch(select) {
			case "1" : consumerMode(); break;
			case "2" : login(); break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}
	
	/**
	 * 로그인
	 */
	public void login() {
		while(true) {
			System.out.println("========[ 로그인 ]========");
			System.out.println();
			System.out.print("   ID : ");
			String id = sc.next();
			System.out.print("   password : ");
			String password = sc.next();
			System.out.println();
			System.out.println("========================");
		
			if((id.equals(Product.getId()) && (password.equals(Product.getPassword())))){
				managerMode();
			}
			else {
				System.err.println("없는 아이디 또는 비밀번호입니다.");
			}
			System.out.print("처음으로 돌아가시겠습니까?(y|n) >> ");
			char ch = sc.next().charAt(0);
			if(ch == 'y'){
				return;
			}
		}	
	}


	/**
	 * 고객 모드 메뉴
	 */
	public void consumerMode() {
		String serve = "┌─────────────────────────────┐\n"
					 + "│  ☆☆☆☆☆☆☆  자판기  ☆☆☆☆☆☆☆  　 │\n"
					 + "│                             │\n"
				     + "│  1. 과자(Snack)               │\n"          
				     + "│                             │\n"
				     + "│  2. 음료(Beverage)            │\n"
				     + "│                             │\n"
				     + "│  3. 생필품(Daily)              │\n"
				     + "│                             │\n"
				     + "└─────────────────────────────┘\n"
				     + "♠ 메뉴선택 : " ;
		
		System.out.print(serve);
		String select = sc.next();
		switch (select) {
		case "1" :
			printList(manager.stockList(select));
			
			break;
		case "2" : 
			printList(manager.stockList(select));
			break;
		case "3" : 
			printList(manager.stockList(select));
			break;
		default: System.out.println("잘못 입력하셨습니다.");
		}
	} // end consumerMode
	
	/**
	 * 제품 카테고리
	 */
	public void category() {
		String serve = "┌─────────────────────────────┐\n"
					 + "│ ==========[ 목록 ]==========  │\n"
					 + "│                             │\n"
					 + "│1.과자                         │\n"          
					 + "│                             │\n"
					 + "│2.음료                         │\n"
					 + "│                             │\n"
					 + "│3.생필품                        │\n"
					 + "│                             │\n"
					 + "└─────────────────────────────┘\n"
					 + "♠ 메뉴선택 : " ;
		System.out.print(serve);
	}
	
	/**
	 * 관리자 모드 메뉴
	 */
	public void managerMode() {
		while(true) {
			String menu = "┌─────────────────────────────┐\n" +
						  "│ =======[ 관리자 모드 ]========= │\n" +
						  "│ 			      │\n" +
						  "│ 1. 재고관리		      │\n" +
						  "│ 			      │\n" +
						  "│ 2. 매출관리		      │\n" +
						  "│			      │\n" +
						  "│ 0. 홈으로		      │\n" +
						  "│                             │\n" +
						  "└─────────────────────────────┘\n" +
						  "♠ 메뉴선택 : " ;
			System.out.print(menu);
			String choice = sc.next();
			switch(choice) {
			case "1" : stockManager(); break;
			case "2" : 
			case "0" : return;
			default : System.out.print("잘못입력하셨습니다.");
			}		
		}
	} // end managerMode
	
	/**
	 * 재고관리
	 */
	public void stockManager() {
		String menu = "┌─────────────────────────────┐\n" +
				  	  "│ ==========[재고관리]========== │\n" +
				  	  "│ 			      │\n" +
				  	  "│ 1. 재고 채우기		      │\n" +
				  	  "│ 2. 제품 삭제		      │\n" +
				  	  "│ 3. 제품 변경		      │\n" +
				  	  "│ 4. 새 제품 추가		      │\n" +
				  	  "│ 0. 돌아가기	              │\n" +
				  	  "│ =========================== │\n" +
				  	  "└─────────────────────────────┘\n" +
				  	  "♠ 메뉴선택 : " ;
		while(true) {
			System.out.print(menu);
			String choice = sc.next();
			try {
				switch(choice) {
				case "1" : 
					while(true) {
						manager.addProduct(selectCategory(), choiceNo());
						System.out.print("계속 재고를 채우시겠습니까?(y|n) >>");
						char select = sc.next().charAt(0);
						if(select == 'n') {
							break;
						}	
					}
					break;
				case "2" : 
					while(true) {
						manager.removeProduct(selectCategory(), choiceNo());
						System.out.print("계속 제품을 삭제하겠습니까?(y|n) >>");
						char select = sc.next().charAt(0);
						if(select == 'n') {
							break;
						}
					}
					break;
				case "3" :
					while(true) {
						manager.replaceProduct(selectCategory(), choiceNo(), newProduct());
						System.out.print("계속 제품을 변경하겠습니까?(y|n) >>");
						char select = sc.next().charAt(0);
						if(select == 'n') {
							break;
						}
					}
					break;
				case "4" :
					while(true) {
						manager.addNewProduct(selectCategory(), newProduct());
						System.out.print("계속 제품을 추가 하시겠습니까?(y|n)");
						char select = sc.next().charAt(0);
						if(select == 'n')
							break;
					}
					break;
				case "0" :
					System.out.println("관리자 메뉴로 돌아갑니다.");
					return;
				default : System.err.println("잘못입력하셨습니다.");	
				}
			}catch (NullPointerException e) {
				System.err.println("잘못입력하셨습니다.");
			}	
		} 
	} // end stockManager
	
	/**
	 * 매출관리(미완성)
	 */
	public void salesManager() {
		
	} // end salesManager
	
	/**
	 * 카테고리 선택
	 * @return
	 */
	public List<Product> selectCategory() {
		category();
		String choice = sc.next();
		printStock(manager.stockList(choice)); 
		return manager.stockList(choice);
	} // end selectStock
	
	/**
	 * 자판기 현황 
	 * @param list
	 */
	public void printList(List<Product> list) {
		System.out.println("================================");
		if(!list.isEmpty()) {
			System.out.println("no.\t제품명 \t 가격 \t 재고량");
			System.out.println("------------------------------");
			int index = 0;
			for(Product p : list) {
				index++;
				System.out.println(index + ".\t" + p);
			}	
		}else {
			System.out.println("잘못 누르셨습니다.");
		}
		System.out.println("-------------------------------");
	} // end printList 

	/**
	 * 재고 현황
	 * @param totalList
	 */
	public void printStock(List<Product> totalList) {
		System.out.println("=============================");
		System.out.println("no.\t 제품명 \t 재고량 \t 가격");
		System.out.println("--------------------------");
		int index = 0;
		for (Product product : totalList){
			index++;
			String name = product.getName();
			int price = product.getPrice();
			int stock = product.getStock();
			System.out.printf("%d.\t %s \t %d \t %d\n", index, name, stock, price);
		}
	} // end printStock
	
	/**
	 * 제품 이름 검색
	 * @return
	 */
	public String searchName() {
		System.out.print("▶ 찾으시는 제품의 이름을 입력해주세요 >> ");
		String name = sc.next();
		return name;
	} // end searchName
	
	public int choiceNo() {
		System.out.print("▶ 번호를 입력해 주세요 >> ");
		int num = sc.nextInt();
		return num;
	}
	
	/**
	 * 제품 추가
	 * @return
	 */
	public Product newProduct(){
		System.out.println();
		System.out.print("▶ 추가할 제품의 이름을 입력해주세요 >> ");
		String name = sc.next();
		System.out.print("▶ 추가할 제품의 가격을 입력해주세요 >> ");
		int price = sc.nextInt();
		System.out.print("▶ 추가할 제품의 수량을 입력해주세요 >> ");
		int quantity = sc.nextInt();
		Product product = new Product(name, price, quantity);
		return product;
	} // end newProdeuct
		
}
