package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {

		ArrayLargeInteger test1 = new ArrayLargeInteger("99");
		ArrayLargeInteger test2 = new ArrayLargeInteger("99");

		System.out.println("Max: " + test1.max(test2));
		System.out.println("Min: " + test1.min(test2));
		System.out.println("Signum: " + test1.signum());
//		test1.multiply("9");
		System.out.println("99*9 = 891");

		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test1.equals(test2));

	}
}
