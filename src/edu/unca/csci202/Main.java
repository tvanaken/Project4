package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {

		ArrayLargeInteger test1 = new ArrayLargeInteger("0");
		ArrayLargeInteger test2 = new ArrayLargeInteger("-99");
		ArrayLargeInteger test3 = new ArrayLargeInteger("99");
		
		test1.multiply(test2);
		
		System.out.println(test1);
		System.out.println(test2);
		
		test1.subtract(test2.abs());
		
		System.out.println(test1);
		System.out.println(test1.min(test2));
		System.out.println(test1.equals(test2));

	}
}
