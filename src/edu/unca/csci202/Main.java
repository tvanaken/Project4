package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {

		ArrayLargeInteger test1 = new ArrayLargeInteger("999");
		ArrayLargeInteger test2 = new ArrayLargeInteger("99");
		
		System.out.print("999 + 99: ");
		test1.add(test2);
		System.out.println(test1);

		System.out.println(test1.equals(test2));

	}
}
