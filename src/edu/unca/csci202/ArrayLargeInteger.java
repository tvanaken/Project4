package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Allows for creation and manipulation of arbitrarily large numbers
 * using ArrayList.
 * @author Taylor Van Aken
 */
public class ArrayLargeInteger implements LargeInteger {

	private ArrayList<Integer> array;
	boolean isNegative = false;
	
	/**
	 * Takes in a large string number and stores it in
	 * an ArrayList
	 * @param num number represented as a String
	 */
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
	
	/**
	 * Converts the ArrayList into a String
	 * @return out the ArrayList represented as a String
	 */
	public String toString() {
		
		String out = "";
		
		if (array.isEmpty()) {
			
			out += "0";
			return out;
		}
		
		while (array.get(0) == 0 && array.size() > 1) {
			
			array.remove(0);
		}
		
		if (isNegative && array.get(0) != 0) {
			out = "-";
		}
		for (int i = 0; i < array.size(); i++) {
			out += array.get(i);
		}
		return out;
	}
	
	/**
	 * Adds two large numbers together and outputs the result regardless
	 * of either one being negative or not.
	 * @return LargeInteger the result of the addition
	 */
	public LargeInteger add(LargeInteger num) {
		
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
				return this;
			} else if (!isNegative && argArray.isNegative) {
				
				argArray.isNegative = false;
				this.subtract(argArray);
				return this;
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
					addition = (array.get(i) + leftOver);
					result.add(addition % 10);
					leftOver = addition / 10;				}
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
					addition = (array.get(i) + leftOver);
					result.add(addition % 10);
					leftOver = addition / 10;
				}
			}
		} else if (this.max(argArray) == argArray) {
			
			if (isNegative && !argArray.isNegative) {
				
				isNegative = false;
				if (this.max(argArray) == this) {
					this.subtract(argArray);
					isNegative = true;
					return this;
				} else {
					this.subtract(argArray);
					isNegative = false;
					return this;
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
					addition = (argArray.array.get(i) + leftOver);
					result.add(addition % 10);
					leftOver = addition / 10;				
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
					addition = (argArray.array.get(i) + leftOver);
					result.add(addition % 10);
					leftOver = addition / 10;
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
				addition = (argArray.array.get(i) + leftOver);
				result.add(addition % 10);
				leftOver = addition / 10;
			}
		}
		
		if (leftOver > 0) {
			result.add(leftOver);
		}
		
		Collections.reverse(result);
		array = result;
		return this;
	}
	
	/**
	 * Subtracts two large numbers from one another and outputs the result regardless
	 * of either one being negative or not.
	 * @return LargeInteger the result of the subtraction
	 */
	public LargeInteger subtract(LargeInteger num) {
		
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
				return this;
			} else if (!isNegative && argArray.isNegative) {
				
				argArray.isNegative = false;
				this.add(argArray);
				isNegative = false;
				return this;
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
				return this;
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
		return this;
	}
	
	/**
	 * Compares two ArrayLargeIntegers to see if they equal one another.
	 * @return int -1, 1, or 0 depending on if it's less than, greater than, or equal to.
	 */
	public int compareTo(Object num) {
		
		ArrayLargeInteger temp = new ArrayLargeInteger(num.toString());
		
		if (this.max(temp) == this) {
			return 1;
		} else if (this.max(temp) == temp) { 
			return -1;
		}
		return 0;
	}

	/**
	 * Returns the negative of the LargeInteger
	 * @return LargeInteger the negative of the original ArrayLargeInteger
	 */
	public LargeInteger negate() {
		
		ArrayLargeInteger temp = new ArrayLargeInteger(this.toString());
		
		temp.isNegative = true;
		
		return temp;
	}

	/**
	 * Returns the absolute value of the LargeInteger
	 * @return LargeInteger the absolute of the original ArrayLargeInteger
	 */
	public LargeInteger abs() {
		
		ArrayLargeInteger temp = new ArrayLargeInteger(this.toString());
		
		temp.isNegative = false;
		
		return temp;
	}

	/**
	 * Multiplies two ArrayLargeIntegers together
	 * @return LargeInteger the result of the multiplication
	 */
	public LargeInteger multiply(LargeInteger num) {
		
		ArrayLargeInteger argArray = new ArrayLargeInteger(num.toString());
		ArrayList<Integer> result = new ArrayList<Integer>();
		int num1Size = array.size();
		int num2Size = argArray.size();
		int top = 0;
		int bottom = 0;
		int first;
		int second;
		result.add(0);
		
		if (argArray.toString().equals("0") || this.toString().equals("0")) {
			array = result;
			isNegative = false;
			return this;
		}
		
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
		return this;
	}

	/**
	 * Compares two ArrayLargeIntegers to find the larger of the two.
	 * @return LargeInteger the larger of the two ArrayLargeIntegers
	 */
	public LargeInteger max(LargeInteger num) {
		
		ArrayLargeInteger argArray = new ArrayLargeInteger(num.toString());
		
		if ((!isNegative && argArray.isNegative)) {
			return this;
		} else if ((isNegative && !argArray.isNegative)) {
			return num;
		} else if (isNegative && argArray.isNegative){
			
			if (this.size() < argArray.size()) {
				return this;
			} else if (this.size() > argArray.size()) {
				return num;
			}
			
			for (int i = 0; i < array.size(); i++) {
				if (array.get(i) < argArray.array.get(i)) {
					return this;
				} else if (array.get(i) > argArray.array.get(i)) {
					return num;
				}
			}
		} else {
		
			if (this.size() > argArray.size()) {
				return this;
			} else if (this.size() < argArray.size()) {
				return num;
			}
			
			for (int i = 0; i < array.size(); i++) {
				
				if (array.get(i) > argArray.array.get(i)) {
					return this;
				} else if (array.get(i) < argArray.array.get(i)) {
					return num;
				}
			}
		}
		return null;
	}
		
	/**
	 * Compares two ArrayLargeIntegers to find the smaller of the two.
	 * @return LargeInteger the smaller of the two ArrayLargeIntegers
	 */
	public LargeInteger min(LargeInteger num) {
		
		ArrayLargeInteger argArray = new ArrayLargeInteger(num.toString());
		
		if ((!isNegative && argArray.isNegative)) {
			return num;
		} else if ((isNegative && !argArray.isNegative)) {
			return this;
		} else if (isNegative && argArray.isNegative){
			
			if (array.size() < argArray.size()) {
				return num;
			} else if (array.size() > argArray.size()) {
				return this;
			}
			
			for (int i = 0; i < array.size(); i++) {
				if (array.get(i) < argArray.array.get(i)) {
					return num;
				} else if (array.get(i) > argArray.array.get(i)) {
					return this;
				}
			}
		} else {
		
			if (array.size() > argArray.size()) {
				return num;
			} else if (array.size() < argArray.size()) {
				return this;
			}
			
			for (int i = 0; i < array.size(); i++) {
				if (array.get(i) > argArray.array.get(i)) {
					return num;
				} else if (array.get(i) < argArray.array.get(i)) {
					return this;
				}
			}
		}
		return null;
	}

	/**
	 * Checks an ArrayLargeInteger to see if it's positive, negative,
	 * or equal to 0;
	 * @return int -1, 1, or 0 if the ArrayLargeInteger is either 
	 * negative, positive, or equal to 0
	 */
	public int signum() {

		if (isNegative) {
			return -1;
		} else if (this.toString().charAt(0) == '0') {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * Returns the size of the ArrayList
	 * @return int the size of the ArrayList
	 */
	public int size() {
		
		return array.size();
	}
	
	/**
	 * Compares two ArrayLargeIntegers to see if they equal one another.
	 * @return boolean true if the ArrayLargeInteger equals the argument
	 */
	public boolean equals(LargeInteger num) {
				
		if ((this.toString().compareTo(num.toString())) == 0) {
			return true;
		} else {
			return false;
		}
	}
}