package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {

		ArrayLargeInteger<String> test1 = new ArrayLargeInteger<String>("-11");
		
		System.out.println(test1);
//		test1.add("111");
//		System.out.println(test1);
		test1.subtract("-1");
		System.out.println(test1);
		
		
	}
}
