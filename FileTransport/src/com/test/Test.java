package com.test;

import java.math.BigDecimal;

public class Test {
	int a;
   public  void a(){
	   a=1;
   }
    public  void ab(){
	   System.out.println(a);
   }
    public static void main(String[] args) {
    	Test t=new Test();
		t.a();
		t.ab();
		
		BigDecimal bigd=new BigDecimal("2343");
    	String s=bigd.multiply(new BigDecimal("100")).divide(new BigDecimal("23333"),2, BigDecimal.ROUND_FLOOR).toString();
	System.out.println(s);
	//System.out.println("sasfafsa16564asfasf".toUpperCase());
	System.out.println("Hello World".indexOf("word"));
    }
}
