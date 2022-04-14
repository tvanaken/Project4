package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLargeInteger implements LargeInteger {

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
		
		if (array.isEmpty()) {
			
			out += "0";
			return out;
		}
		
		while (array.get(0) == 0 && array.size() > 1) {
			
			array.remove(0);
		}

		if (isNegative) {
			out = "-";
		}
		for (int i = 0; i < array.size(); i++) {
			out += array.get(i);
		}
		return out;
	}
	
	public void add(LargeInteger num) {
		
		ArrayLargeInteger argArray = new ArrayLargeInteger(num.toString());
		ArrayList<Integer> result = new ArrayList<Integer>();
		int num1Size = array.size() - 1;
		int num2Size = argArray.size() - 1;
		int largeInt;
		int smallInt;
		int lengthDiff;
		int addition = 0;
		int leftOver = 0;
		
		if (this.max(argArray) == this) {
			
			if (isNegative && !argArray.isNegative) {
				
				this.subtract(num);
				isNegative = true;
				return;
			} else if (!isNegative && argArray.isNegative) {
				
				argArray.isNegative = false;
				this.subtract(argArray);
				return;
			} else if (isNegative && argArray.isNegative) {
				
				lengthDiff = num2Size - num1Size;
				for (int i = num1Size; i >= 0; i--) {
					
					largeInt = array.get(i);
					smallInt = argArray.array.get(i + lengthDiff);
					addition = largeInt + smallInt + leftOver;
					result.add(addition % 10);
					leftOver = addition / 10;
				}
	
				for (int i = lengthDiff - 1; i >= 0; i--) {
					result.add((array.get(i) + leftOver) % 10);
				}
			} else {
			
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
			}
		} else if (this.max(argArray) == argArray) {
			
			if (isNegative && !argArray.isNegative) {
				
				isNegative = false;
				if (this.max(argArray) == this) {
					this.subtract(argArray);
					isNegative = true;
					return;
				} else {
					this.subtract(argArray);
					isNegative = false;
					return;
				}
				
			} else if (isNegative && argArray.isNegative) {
				
				lengthDiff = num1Size - num2Size;
				for (int i = num2Size; i >= 0; i--) {
					
					smallInt = array.get(i + lengthDiff);
					largeInt = argArray.array.get(i);
					addition = largeInt + smallInt + leftOver;
					result.add(addition % 10);
					leftOver = addition / 10;
				}
				for (int i = lengthDiff - 1; i >= 0; i--) {
					result.add((argArray.array.get(i) + leftOver) % 10);
				}
			} else {
			
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
		} else {
			
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
	
	public void subtract(LargeInteger num) {
		
		ArrayLargeInteger argArray = new ArrayLargeInteger(num.toString());
		ArrayList<Integer> result = new ArrayList<Integer>();
		int num1Size = array.size() - 1;
		int num2Size = argArray.size() - 1;
		int largeInt;
		int smallInt;
		int lengthDiff;
		int difference = 0;
		int leftOver = 0;
				
		if (this.max(argArray) == this) {

			if (isNegative && !argArray.isNegative) {

				isNegative = false;
				
				this.add(num);
				return;
			} else if (!isNegative && argArray.isNegative) {
				
				argArray.isNegative = false;
				this.add(argArray);
				isNegative = false;
				return;
			} else if (isNegative && argArray.isNegative){
				
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
					if (array.get(i) == 0 && leftOver > 0) {
						result.add(9);
						continue;
					}
					difference = array.get(i) - leftOver;
					if (difference > 0 || i > 0) {
						result.add(difference);
					}
					leftOver = 0;
				}
				isNegative = false;
			} else {
			
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
						continue;
					}
					difference = array.get(i) - leftOver;
					if (difference > 0 || i > 0) {
						result.add(difference);
					}
					leftOver = 0;
				}
			}
		} else if (this.max(argArray) == argArray) {
			
			if (isNegative && !argArray.isNegative) {
				
				isNegative = false;
				this.add(argArray);
				isNegative = true;
				return;
			} else if (isNegative && argArray.isNegative) {
				
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
						continue;
					}
					difference = array.get(i) - leftOver;
					if (difference > 0 || i > 0) {
						result.add(difference);
					}
					leftOver = 0;
				}
				isNegative = true;
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
					continue;
				}
				difference = argArray.array.get(i) - leftOver;
				if (difference > 0 || i > 0) {
					result.add(difference);
				}
				leftOver = 0;
			}
			isNegative = true;
			}
		}

		Collections.reverse(result);
		array = result;
	}
	
	public int compareTo(Object o) {
		return 0;
	}

	public void negate() {
		
		isNegative = true;
	}

	public void abs() {
		
		isNegative = false;
	}

	public void multiply(String num) {
		
		ArrayLargeInteger argArray = new ArrayLargeInteger(num);
		ArrayList<Integer> result = new ArrayList<Integer>();
		int num1Size = array.size();
		int num2Size = argArray.size();
		int top = 0;
		int bottom = 0;
		int first;
		int second;
		result.add(0);
		
		for (int i = num1Size - 1; i >= 0; i--) {
			bottom = 0;
			int leftOver = 0;
			first = array.get(i);
			
			
			for (int j = num2Size - 1; j >= 0; j--) {
				second = argArray.array.get(j);
				int product = first * second;
				try {
					product += result.get(top + bottom) + leftOver;
				} catch (IndexOutOfBoundsException e) {
					product += leftOver;
				}
				leftOver = product / 10;
				try {
					result.set(top + bottom, product % 10);
				} catch (IndexOutOfBoundsException e) {
					result.add(product % 10);
				}
				
				bottom++;
			}
			if (leftOver > 0) {
				result.add(0);
				result.set(top + bottom, result.get(top + bottom) + leftOver);
			}
			top++;
		}
		
		if ((argArray.isNegative && !isNegative) || (isNegative == true && !argArray.isNegative)) {
			isNegative = true;
		} else if (isNegative && argArray.isNegative) {
			isNegative = false;
		}
		Collections.reverse(result);
		array = result;
	}

	public LargeInteger max(LargeInteger num) {
		
		ArrayLargeInteger argArray = new ArrayLargeInteger(num.toString());
		
		if ((!isNegative && argArray.isNegative)) {
			return this;
		} else if ((isNegative && !argArray.isNegative)) {
			return num;
		} else if (isNegative && argArray.isNegative){
			
			for (int i = 0; i < array.size(); i++) {
				if ((array.get(i) < argArray.array.get(i)) || (array.size() < argArray.size())) {
					return this;
				} else if ((array.get(i) > argArray.array.get(i)) || (array.size() > argArray.size())) {
					return num;
				}
			}
		} else {
		
			for (int i = 0; i < array.size(); i++) {
				if ((array.get(i) > argArray.array.get(i)) || (array.size() > argArray.size())) {
					return this;
				} else if ((array.get(i) < argArray.array.get(i)) || (array.size() < argArray.size())) {
					return num;
				}
			}
		}
		return null;
	}
		

	public LargeInteger min(LargeInteger num) {
		
		ArrayLargeInteger argArray = new ArrayLargeInteger(num.toString());
		
		if ((!isNegative && argArray.isNegative)) {
			return num;
		} else if ((isNegative && !argArray.isNegative)) {
			return this;
		} else if (isNegative && argArray.isNegative){
			
			for (int i = 0; i < array.size(); i++) {
				if ((array.get(i) < argArray.array.get(i)) || (array.size() < argArray.size())) {
					return num;
				} else if ((array.get(i) > argArray.array.get(i)) || (array.size() > argArray.size())) {
					return this;
				}
			}
		} else {
		
			for (int i = 0; i < array.size(); i++) {
				if ((array.get(i) > argArray.array.get(i)) || (array.size() > argArray.size())) {
					return num;
				} else if ((array.get(i) < argArray.array.get(i)) || (array.size() < argArray.size())) {
					return this;
				}
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
	
	public boolean equals(LargeInteger num) {
				
		if ((this.toString().compareTo(num.toString())) == 0) {
			return true;
		} else {
			return false;
		}
	}
}