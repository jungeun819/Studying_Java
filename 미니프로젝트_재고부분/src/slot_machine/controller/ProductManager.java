package slot_machine.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.NameNotFoundException;

import slot_machine.io.ProductIO;
import slot_machine.model.vo.Product;

public class ProductManager {
	private Scanner sc = new Scanner(System.in);
	private ProductIO productIO = new ProductIO();
	private List<Product> snackList = new ArrayList<Product>();
	private List<Product> beverageList = new ArrayList<Product>();
	private List<Product> dailyList = new ArrayList<Product>();
	
	

	public ProductManager() {
		List<Product> snackList = productIO.loadSnackList();
		this.snackList = snackList != null ? 
							snackList :
								new ArrayList<>();
		List<Product> beverageList = productIO.loadbeverageList();
		this.beverageList = beverageList != null ? 
				beverageList :
					new ArrayList<>();
		List<Product> dailyList = productIO.loadDailyList();
		this.dailyList = dailyList != null ? 
				dailyList :
					new ArrayList<>();
		
		
	}

	{
		snackList.add(new Product("빼빼로",1700,5));
		snackList.add(new Product("계란과자",1700,5));
		snackList.add(new Product("스윙칩",1700,5));
		snackList.add(new Product("통크",1700,5));
		
		beverageList.add(new Product("포카리",1700,3));
		beverageList.add(new Product("코카콜라",1700,3));
		beverageList.add(new Product("칠성사이다",1700,3));
		beverageList.add(new Product("닥터페퍼",1700,3));
		
		dailyList.add(new Product("물휴지",500,10));
		dailyList.add(new Product("휴지",500,10));
		dailyList.add(new Product("건전지",500,10));
		dailyList.add(new Product("보조배터리",500,10));
		
	}
		
	/**
	 * 1. 재고 채우기
	 * @param list
	 * @param name
	 */
	public void addProduct(List<Product> list, int num){
		// 수량이 10개 이하인 경우만 추가 가능(진열 최대 10개 가능)
		if(list.get(num - 1).getStock() < 10) {
			System.out.print("▶ 수량을 입력해주세요 >> ");
			int add = sc.nextInt();
			try {
				// 추가한 재고가 10개를 넘을 경우 예외 처리
				int total = list.get(num - 1).getStock() + add;
				checkQuantity(total);
				list.get(num - 1).setStock(total);
				System.out.printf("▷ [%d개] 추가 -> %s(%d)\n", add, list.get(num - 1).getName() , total);
			} catch (StockOverflowException e) {
				System.err.println(" ※ 10개 이상 채울 수 없습니다 ※ ");
			}
		}else {
			System.err.print(" ※ 10개까지만 진열 가능합니다 ※\n"); 
		}
		howFileSave(list);
	} // end addProduct
	

	/**
	 * 2. 제품 삭제
	 * @param list
	 * @param name
	 */
	public void removeProduct(List<Product> list, int num) {
		try {
			String name = list.get(num - 1).getName();
			list.remove(num - 1);
			System.out.printf("▷ [%s]를 삭제했습니다.\n", name);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("※ 없는 번호입니다 ※");
		}
	} // end removerProduct 
	
	/**
	 * 3. 제품 변경
	 * @param list
	 * @param name
	 * @param newList
	 */
	public void replaceProduct(List<Product> list, int num, Product newList) {
		try {
			String oldName = list.get(num - 1).getName();
			list.set(num - 1, newList);
			System.out.printf("[%s -> %s]\n", oldName, newList.getName());
			howFileSave(list);
		}catch (IndexOutOfBoundsException e) {
			System.err.println("※ 없는 번호입니다 ※");
		}
	} // end replaceProduct
	
	/**
	 * 4. 새 제품 추가
	 * @param list
	 * @param product
	 */
	public void addNewProduct(List<Product> list, Product product) {
		if(list.size() <= 5) {
			list.add(product);
			System.out.printf("[%s]을 추가했습니다.\n", product.getName());
			howFileSave(list);
		}else 				
			System.err.println("※ 진열장이 부족합니다 ※");
	} // end addNewProduct
	
	/**
	 * 카테고리별 재고 현황 확인용
	 */
	public List<Product> stockList(String num) {
		switch (num) {
		case "1" : return snackList;  
		case "2" : return beverageList; 
		case "3" : return dailyList; 
		default : System.err.println("※ 잘못입력하셨습니다 ※");
		}
		return null;
	}
		
		
	/**
	 * 제품별 수량 10개로 제한
	 * @param quantity
	 * @throws StockOverflowException
	 */
	public void checkQuantity(int quantity) throws StockOverflowException{
		if(quantity > 10) {
			throw new StockOverflowException();
		} 
	} // end checkQuantity
	
	/**
	 * 검색한 이름이 리스트에 있는지 확인용
	 *  -> 있다면 리스트의 인덱스 값 반환
	 * @param list
	 * @param name
	 * @return
	 * @throws NameNotFoundException
	 */
	public int checkName(List<Product> list, String name) throws NameNotFoundException {
		int index = 0;
		for(int i = 0; i < list.size(); i++) {
			if(name.equals(list.get(i).getName())) {
				index = i;
				return index;
			}
		}
		throw new NameNotFoundException();
	} // end checkName
	
	public void howFileSave(List<Product> list) {
		if(list.equals(snackList)) {
			productIO.saveSnackList(snackList);
		}else if (list.equals(beverageList)) {
			productIO.savebeverageList(beverageList);
		}else {
			productIO.savedailyList(dailyList);
		}
	}
}
