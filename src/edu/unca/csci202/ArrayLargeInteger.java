package edu.unca.csci202;

import java.util.ArrayList;

public class ArrayLargeInteger<T> implements LargeInteger<T> {

	private ArrayList<Character> array;
	private char[] broken;
	
	public ArrayLargeInteger(String num) {
		
		array = new ArrayList<Character>();
		
		for (int i = 0; i < num.length(); i++) {
			array.add(num.charAt(i));
		}
	}
	
	public String toString() {
		
		String out = "[";
		for (int i = 0; i < array.size() - 1; i++) {
			out += array.get(i) + ", ";
		}
		out += array.get(array.size() - 1) + "]";
		return out;
	}
	
	public int compareTo(T o) {
		return 0;
	}

	public ArrayList<Character> add(String num) {
		
		int string1 = array.size() - 1;
		int string2 = num.length() - 1;
		char num1;
		char num2;
		String result = null;
		int smaller = string1;
		
		if (string1 > string2) {
			smaller = string2;
		}
		
		for (int i = smaller; i >= 0; i--) {
			num1 = array.get(string1);
			num2 = num.charAt(string2);
			char add = (char) (num1 + num2);
			array.set(string1, add);
			string1--;
			string2--;
		}
		
		return array;
	}

	public T subtract(T num) {
		return null;
	}

	public T negate() {
		return null;
	}

	public T abs() {
		return null;
	}

	public T multiply(T num) {
		return null;
	}

	public T max(T num) {
		return null;
	}

	public T min(T num) {
		return null;
	}

	public T signum(T num) {
		return null;
	}

	public int size() {
		return array.size();
	}
}
