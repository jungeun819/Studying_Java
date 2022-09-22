package com.sh.oop.book.controller;

import com.sh.oop.book.model.Book;

public class TestBook {

	public static void main(String[] args) {
		Book book1 = new Book("뇌를 자극하는 JAVA", 20000, 0.2, "김윤영");
//		book1.bookInformation();
		int b1Price = (int)(book1.getPrice() - (book1.getPrice() * book1.getDiscountRate()));
		
		Book book2 = new Book("자바의 정석", 35000, 0.1, "윤상섭");
//		book2.bookInformation();
		int b2Price = (int)(book2.getPrice() - (book2.getPrice() * book2.getDiscountRate()));
		
		System.out.println("도서명 : " + book1.getTitle());
		System.out.println("할인된 가격 : " + b1Price);
		System.out.println("도서명 : " + book2.getTitle());
		System.out.println("할인된 가격 : " + b2Price);
	}

}
