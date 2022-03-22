package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {

		ArrayLargeInteger<String> test1 = new ArrayLargeInteger<String>("1321346547981598897641");
		
		System.out.println(test1);
//		test1.add("111");
//		System.out.println(test1);
		test1.add("-123");
		System.out.println(test1);
		
	}
}
