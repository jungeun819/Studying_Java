package com.sh.oop.method;

public class Test {
    int a = 100;
    static int s = 99;
    
    public static void main(String[] args) {
        Test t = new Test();
        t.test1(); // 100 99
        
        t.test2(); // 100
        
        Test t3 = new Test();
        t.test3(t3); // 10
        System.out.println(t3.a); // 10
        
  
            
    }

    public void test1() {
        int a = 1000;
        int s = 999;
        System.out.println(this.a); // t.test1 -> t.a = 100
        System.out.println(Test.s); // Test.s = 99
    }

    public void test2() {
        Test t = new Test();
        t.a = 1000; // t(위에랑 다름).test.a = 1000
        System.out.println(a); // Test.a = 100
    }

    public void test3(Test t) { // t.test(t3)
        t.a = 10; //  t3.a = 10
        this.a = 200; // t.a = 10
        System.out.println(t.a); // t3.a = 10
    }


}