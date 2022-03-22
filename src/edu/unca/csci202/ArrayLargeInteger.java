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
		
		ArrayLargeInteger<String> argArray = new ArrayLargeInteger<String>(num);
		ArrayList<Integer> result = new ArrayList<Integer>();
		int num1Size = array.size() - 1;
		int num2Size = argArray.size() - 1;
		int largeInt;
		int smallInt;
		int lengthDiff;
		int addition = 0;
		int leftOver = 0;
		
		
		
		if (num1Size > num2Size) {
			
			if ((isNegative && !argArray.isNegative) || (!isNegative && argArray.isNegative)) {
				
				this.subtract(num);
				return;
			}
			
			lengthDiff = num1Size - num2Size;
			for (int i = num2Size; i >= 0; i--) {
				
				largeInt = array.get(i + lengthDiff);
				smallInt = argArray.array.get(i);
				addition = largeInt + smallInt + leftOver;
				result.add(addition % 10);
				leftOver = addition / 10;
			}

			for (int i = lengthDiff - 1; i >= 0; i--) {
				result.add((array.get(i) + leftOver) % 10);
			}
		} else {
			
			if (isNegative && !argArray.isNegative) {
				
				this.subtract(num);
				isNegative = false;
				return;
			}
			
			lengthDiff = num2Size - num1Size;
			for (int i = num1Size; i >= 0; i--) {
				
				largeInt = array.get(i);
				smallInt = argArray.array.get(i + lengthDiff);
				addition = largeInt + smallInt + leftOver;
				result.add(addition % 10);
				leftOver = addition / 10;
			}
			
			for (int i = lengthDiff - 1; i >= 0; i--) {
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
		
		ArrayLargeInteger<String> argArray = new ArrayLargeInteger<String>(num);
		ArrayList<Integer> result = new ArrayList<Integer>();
		int num1Size = array.size() - 1;
		int num2Size = argArray.size() - 1;
		int largeInt;
		int smallInt;
		int lengthDiff;
		int difference = 0;
		int leftOver = 0;
				
		if (num1Size > num2Size) {
			
			lengthDiff = num1Size - num2Size;
			for (int i = num2Size; i >= 0; i--) {
				
				largeInt = array.get(i + lengthDiff);
				smallInt = argArray.array.get(i);
				difference = largeInt - smallInt - leftOver;

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
				
				smallInt = array.get(i);
				largeInt = argArray.array.get(i + lengthDiff);
				difference = largeInt - smallInt - leftOver;
				if (difference < 0) {
					difference += 10;
					leftOver = 1;
				} else {
					leftOver = 0;
				}
				result.add(difference);
			}
			
			for (int i = lengthDiff - 1; i >= 0; i--) {
				if (argArray.array.get(i) == 0 && leftOver > 0) {
					result.add(9);
					break;
				}
				difference = argArray.array.get(i) - leftOver;
				if (difference > 0 || i > 0) {
					result.add(difference);
				}
				leftOver = 0;
			}
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

	public LargeInteger<T> max(ArrayLargeInteger<T> num) {
		
		int num1Size = array.size() - 1;
		int num2Size = num.array.size() - 1;
		boolean obLarger = false;
		boolean argLarger = false;
		
		for (int i = 0; obLarger == false || argLarger == false; i++) {
			if (array.get(i) > num.array.get(i)) {
				obLarger = true;
				return this;
				
			} else if (array.get(i) > num.array.get(i)) {
				argLarger = true;
				return num;
			}
		}
		return null;
	}
		

	public LargeInteger<T> min(ArrayLargeInteger<T> num) {
		
		int num1Size = array.size() - 1;
		int num2Size = num.array.size() - 1;
		boolean obSmaller = false;
		boolean argSmaller = false;
		
		for (int i = 0; obSmaller == false || argSmaller == false; i++) {
			if (array.get(i) < num.array.get(i)) {
				obSmaller = true;
				return this;
				
			} else if (array.get(i) > num.array.get(i)) {
				argSmaller = true;
				return num;
			}
		}
		return null;
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
