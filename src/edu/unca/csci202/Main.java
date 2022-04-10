package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {

		ArrayLargeInteger test1 = new ArrayLargeInteger("100");
		ArrayLargeInteger test2 = new ArrayLargeInteger("99");

		System.out.println("Max: " + test1.max(test2));
		System.out.println("Min: " + test1.min(test2));
		System.out.println("Signum: " + test1.signum());

		System.out.println(test1);
		test1.abs();
		System.out.println(test1);

	}
}
