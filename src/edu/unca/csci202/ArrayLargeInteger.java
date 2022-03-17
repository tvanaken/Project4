package edu.unca.csci202;

import java.util.ArrayList;

public class ArrayLargeInteger<T> implements LargeInteger<T> {

	private ArrayList<T> array;
	
	public ArrayLargeInteger(String num) {
		
		array = new ArrayList<T>();
		for (int i = 0; i < num.length(); i++) {
			array.add(num.charAt(i));
		}
	}
	
	public int compareTo(T o) {
		return 0;
	}

	public T add(T num) {
		return null;
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
}
