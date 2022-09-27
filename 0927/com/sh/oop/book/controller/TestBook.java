package com.sh.oop.book.controller;

import com.sh.oop.book.model.vo.Book;

public class TestBook {

	public static void main(String[] args) {

		Book book1 = new Book("뇌를 자극하는 JAVA", "김윤영", 20000);
		Book book2 = new Book("자바의 정석", "윤상섭", 35000);
		
		System.out.println(book1.toString()); 
		System.out.println(book2.toString());
		
		System.out.println(book1.equals(book2)); // false
		
		Book book3 = book1.clone();
		System.out.println(book1.hashCode()== book3.hashCode()); // true
		System.out.println(book1.equals(book3)); // true
		
	}

}
