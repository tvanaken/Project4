package edu.unca.csci202;

public class Main {

	public static void main(String[] args) {
		
		ArrayLargeInteger test1 = new ArrayLargeInteger("99");
		ArrayLargeInteger test2 = new ArrayLargeInteger("999");
		ArrayLargeInteger test3 = new ArrayLargeInteger("900");
		
		
		System.out.println("test1: "+ test1);
		System.out.println("test2: "+ test2);
		System.out.println(test1.multiply(test2));
		System.out.println("test1: "+ test1);
		System.out.println("test2: "+ test2);
		System.out.println(test2.equals(test1.add(test3)));
		
//		double totalTime = 0;
//		double time1 = 0;
//		double time2 = 0;
//		
//		ArrayLargeInteger buff = new ArrayLargeInteger("9");
//
//		ArrayLargeInteger test1 = new ArrayLargeInteger("99999999999999999999999999999999999999999999999999");
//		ArrayLargeInteger test2 = new ArrayLargeInteger("99999999999999999999999999999999999999999999999999");
//		LinkedLargeInteger linked1 = new LinkedLargeInteger("99999999999999999999999999999999999999999999999999");
//		LinkedLargeInteger linked2 = new LinkedLargeInteger("99999999999999999999999999999999999999999999999999");
//		
//		buff.min(test1);
//		
//		System.out.println(test1.size() * 2);
//		
//		time1 = System.nanoTime();
//		test1.multiply(test2);
//		time2 = System.nanoTime();
//		totalTime = (time2 - time1) / 1000;
//		System.out.println(totalTime);
//				
//		time1 = System.nanoTime();
//		linked1.multiply(linked2);
//		time2 = System.nanoTime();
//		totalTime = (time2 - time1) / 1000;
//		System.out.println(totalTime);
//		
//		System.out.println();
//
//		
//		test1 = new ArrayLargeInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		test2 = new ArrayLargeInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		linked1 = new LinkedLargeInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		linked2 = new LinkedLargeInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		
//		System.out.println(test1.size() * 2);
//		
//		time1 = System.nanoTime();
//		test1.multiply(test2);
//		time2 = System.nanoTime();
//		totalTime = (time2 - time1) / 1000;
//		System.out.println(totalTime);
//				
//		time1 = System.nanoTime();
//		linked1.multiply(linked2);
//		time2 = System.nanoTime();
//		totalTime = (time2 - time1) / 1000;
//		System.out.println(totalTime);
//		
//		System.out.println();
//
//		
//		test1 = new ArrayLargeInteger("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		test2 = new ArrayLargeInteger("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		linked1 = new LinkedLargeInteger("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		linked2 = new LinkedLargeInteger("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		
//		System.out.println(test1.size() * 2);
//		
//		time1 = System.nanoTime();
//		test1.multiply(test2);
//		time2 = System.nanoTime();
//		totalTime = (time2 - time1) / 1000;
//		System.out.println(totalTime);
//				
//		time1 = System.nanoTime();
//		linked1.multiply(linked2);
//		time2 = System.nanoTime();
//		totalTime = (time2 - time1) / 1000;
//		System.out.println(totalTime);
//
//		System.out.println();
//
//		test1 = new ArrayLargeInteger("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		test2 = new ArrayLargeInteger("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		linked1 = new LinkedLargeInteger("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		linked2 = new LinkedLargeInteger("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		
//		System.out.println(test1.size() * 2);
//		
//		time1 = System.nanoTime();
//		test1.multiply(test2);
//		time2 = System.nanoTime();
//		totalTime = (time2 - time1) / 1000;
//		System.out.println(totalTime);
//				
//		time1 = System.nanoTime();
//		linked1.multiply(linked2);
//		time2 = System.nanoTime();
//		totalTime = (time2 - time1) / 1000;
//		System.out.println(totalTime);
//
//		System.out.println();
//
//		test1 = new ArrayLargeInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		test2 = new ArrayLargeInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		linked1 = new LinkedLargeInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		linked2 = new LinkedLargeInteger("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		
//		System.out.println(test1.size() * 2);
//		
//		time1 = System.nanoTime();
//		test1.multiply(test2);
//		time2 = System.nanoTime();
//		totalTime = (time2 - time1) / 1000;
//		System.out.println(totalTime);
//				
//		time1 = System.nanoTime();
//		linked1.multiply(linked2);
//		time2 = System.nanoTime();
//		totalTime = (time2 - time1) / 1000;
//		System.out.println(totalTime);
//
//		System.out.println();
//		
//		test1 = new ArrayLargeInteger("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		test2 = new ArrayLargeInteger("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		linked1 = new LinkedLargeInteger("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		linked2 = new LinkedLargeInteger("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
//		
//		System.out.println(test1.size() * 2);
//		
//		time1 = System.nanoTime();
//		test1.multiply(test2);
//		time2 = System.nanoTime();
//		totalTime = (time2 - time1) / 1000;
//		System.out.println(totalTime);
//				
//		time1 = System.nanoTime();
//		linked1.multiply(linked2);
//		time2 = System.nanoTime();
//		totalTime = (time2 - time1) / 1000;
//		System.out.println(totalTime);
//
//		System.out.println();
	}
}
