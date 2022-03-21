package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayLargeInteger<T> implements LargeInteger<T> {

	private ArrayList<Integer> array;
	boolean isNegative = false;
	
	public ArrayLargeInteger(String num) {
		
		array = new ArrayList<Integer>();
		int a = 0;
		
		for (int i = 0; i < num.length(); i++) {
			
			if (num.charAt(0) == '-') {
				num = num.substring(1);
				while(num.charAt(0) == '0') {
					num = num.substring(1);
				}
				a = Integer.parseInt(String.valueOf(num.charAt(i)));
				array.add(a);
				isNegative = true;
			} else {
				a = Integer.parseInt(String.valueOf(num.charAt(i)));
				array.add(a);
			}
		}
	}
	
	public String toString() {
		
		String out = "";
		if (isNegative) {
			out = "-";
		}
		for (int i = 0; i < array.size(); i++) {
			out += array.get(i);
		}
		return out;
	}
	
	public void add(String num) {
		
		int num1Size = array.size() - 1;
		int num2Size = num.length() - 1;
		int arrayInt;
		int argInt;
		int lengthDiff;
		int addition = 0;
		int leftOver = 0;
//		String[] numArray = num.split("");
//		int[] arg = new int [num.length()];
		ArrayLargeInteger<String> argArray = new ArrayLargeInteger<String>(num);
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (isNegative && num.charAt(0) != '-') {
			
			this.subtract(num);
			return;
		}
		
		if (num1Size > num2Size) {
			
			lengthDiff = num1Size - num2Size;
			for (int i = num2Size; i >= 0; i--) {
				
				arrayInt = array.get(i + lengthDiff);
				argInt = argArray.array.get(i);
				addition = arrayInt + argInt + leftOver;
				result.add(addition % 10);
				leftOver = addition / 10;
			}

			for (int i = lengthDiff - 1; i >= 0; i--) {
				result.add((array.get(i) + leftOver) % 10);
			}
		} else {
			
			lengthDiff = num2Size - num1Size;
			for (int i = num1Size; i >= 0; i--) {
				
				arrayInt = array.get(i);
				argInt = argArray.array.get(i + lengthDiff);
				addition = arrayInt + argInt + leftOver;
				result.add(addition % 10);
				leftOver = addition / 10;
			}
			
			for (int i = lengthDiff - 1; i >= 0; i--) {
				//result.add((array.get(i) + leftOver) % 10);
				result.add((argArray.array.get(i) + leftOver) % 10);
			}
		}
		
		if (leftOver > 0) {
			result.add(leftOver);
		}
		
		Collections.reverse(result);
		array = result;
	}
	
	public void subtract(String num) {
		
		int num1Size = array.size() - 1;
		int num2Size = num.length() - 1;
		int arrayInt;
		int argInt;
		int lengthDiff;
		int difference = 0;
		int leftOver = 0;
		String[] numArray = num.split("");
		int[] arg = new int[num.length()];
		ArrayList<Integer> argArray = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < num.length(); i++) {
			arg[i] = Integer.valueOf(numArray[i]);
		}
				
		if (num1Size > num2Size) {
			
			lengthDiff = num1Size - num2Size;
			for (int i = num2Size; i >= 0; i--) {
				
				arrayInt = array.get(i + lengthDiff);
				argInt = arg[i];
				difference = arrayInt - argInt - leftOver;

				if (difference < 0) {
					difference += 10;
					leftOver = 1;
				} else {
					leftOver = 0;
				}
				result.add(difference);
			}

			for (int i = lengthDiff - 1; i >= 0; i--) {
				if (array.get(i) == 0 && leftOver > 0) {
					result.add(9);
					break;
				}
				difference = array.get(i) - leftOver;
				if (difference > 0 || i > 0) {
					result.add(difference);
				}
				leftOver = 0;
			}
		} else {
			
			lengthDiff = num2Size - num1Size;
			for (int i = num1Size; i >= 0; i--) {
				
				arrayInt = array.get(i);
				argInt = arg[i + lengthDiff];
				difference = argInt - arrayInt - leftOver;
				if (difference < 0) {
					difference += 10;
					leftOver = 1;
				} else {
					leftOver = 0;
				}
				result.add(difference);
			}
			
			for (int i = lengthDiff - 1; i >= 0; i--) {
				if (arg[i] == 0 && leftOver > 0) {
					result.add(9);
					break;
				}
				difference = arg[i] - leftOver;
				if (difference > 0 || i > 0) {
					result.add(difference);
				}
				leftOver = 0;
			}
			isNegative = true;
		}

		Collections.reverse(result);
		array = result;
	}
	
	public int compareTo(T o) {
		return 0;
	}

	public void negate() {
		
		isNegative = true;
	}

	public T abs() {
		return null;
	}

	public void multiply(T num) {
		
	}

	public LargeInteger<T> max(String num) {
		
		int num1Size = array.size() - 1;
		int num2Size = num.length() - 1;
		if (num1Size > num2Size) {
			
			return (LargeInteger<T>) this;
		} else if (num1Size < num2Size) {
			
			LargeInteger<T> argArray = new ArrayLargeInteger<T>(num);
			return (LargeInteger<T>) argArray;
			}
		return (LargeInteger<T>) this;
	}
		

	public LargeInteger<T> min(String num) {
		
		int num1Size = array.size() - 1;
		int num2Size = num.length() - 1;
		if (num1Size < num2Size) {
			
			return this;
		} else if (num1Size > num2Size) {
			
			ArrayLargeInteger<T> argArray = new ArrayLargeInteger<T>(num);
			return argArray;
			}
		return this;
	}

	public int signum() {

		if (this.toString().charAt(0) == '-') {
			return -1;
		} else if (this.toString().charAt(0) == '0') {
			return 0;
		} else {
			return 1;
		}
	}

	public int size() {
		
		return array.size();
	}
}
