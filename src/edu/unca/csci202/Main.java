package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {

		ArrayLargeInteger test1 = new ArrayLargeInteger("100");
//		ArrayLargeInteger test2 = new ArrayLargeInteger("-100");
		
//		System.out.println(test1.max(test2));
		
		System.out.println(test1);
		test1.add("100");
		System.out.println(test1);
		
	}
}
