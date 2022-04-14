package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {

		ArrayLargeInteger test1 = new ArrayLargeInteger("99");
		ArrayLargeInteger test2 = new ArrayLargeInteger("99");
		
		test1.add(test2);
		System.out.println(test1);
		System.out.println(test2);

		System.out.println(test1.equals(test2));

	}
}
