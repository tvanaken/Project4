package edu.unca.csci202;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Allows for creation and manipulation of arbitrarily large numbers
 * using LinkedList.
 * @author Taylor Van Aken
 */
public class LinkedLargeInteger implements LargeInteger {

	private LinkedList<Integer> list;
	boolean isNegative = false;
	
	/**
	 * Takes in a large string number and stores it in
	 * an LinkedList
	 * @param num number represented as a String
	 */
	public LinkedLargeInteger(String num) {
		
		list = new LinkedList<Integer>();
		int a = 0;
		
		for (int i = 0; i< num.length(); i++) {
			
			if (num.charAt(0) == '-') {
				num = num.substring(1);
				while(num.charAt(0) == '0') {
					num = num.substring(1);
				}
				a = Integer.parseInt(String.valueOf(num.charAt(i)));
				list.add(a);
				isNegative = true;
			} else {
				a = Integer.parseInt(String.valueOf(num.charAt(i)));
				list.add(a);
			}
		}
	}
	
	/**
	 * Converts the LinkedList into a String
	 * @return out the LinkedList represented as a String
	 */
	public String toString() {
		
		String out = "";
		
		if (list.isEmpty()) {
			
			out += "0";
			return out;
		}
		
		while (list.get(0) == 0 && list.size() > 1) {
			
			list.remove(0);
		}
		
		if (isNegative && list.get(0) != 0) {
			out = "-";
		}
		for (int i = 0; i < list.size(); i++) {
			out += list.get(i);
		}
		return out;
	}
	
	/**
	 * Compares two LinkedLargeIntegers to see if they equal one another.
	 * @return int -1, 1, or 0 depending on if it's less than, greater than, or equal to.
	 */
	public int compareTo(Object num) {
		
		LinkedLargeInteger temp = new LinkedLargeInteger(num.toString());
		
		if (this.max(temp) == this) {
			return 1;
		} else if (this.max(temp) == temp) { 
			return -1;
		}
		return 0;
	}

	/**
	 * Adds two large numbers together and outputs the result regardless
	 * of either one being negative or not.
	 * @return LargeInteger the result of the addition
	 */
	public LargeInteger add(LargeInteger num) {


		LinkedLargeInteger argList = new LinkedLargeInteger(num.toString());
		LinkedLargeInteger result = new LinkedLargeInteger("");
		int num1Size = list.size() - 1;
		int num2Size = argList.size() - 1;
		int largeInt;
		int smallInt;
		int lengthDiff;
		int addition = 0;
		int leftOver = 0;
		
		if (this.max(argList) == this) {
			
			if (!isNegative && argList.isNegative) {
				
				return this.subtract(argList.negate());
			} else if (isNegative && argList.isNegative) {
				
				lengthDiff = num2Size - num1Size;
				for (int i = num1Size; i >= 0; i--) {
					
					largeInt = list.get(i);
					smallInt = argList.list.get(i + lengthDiff);
					addition = largeInt + smallInt + leftOver;
					result.list.add(addition % 10);
					leftOver = addition / 10;
				}
	
				for (int i = lengthDiff - 1; i >= 0; i--) {
					addition = (list.get(i) + leftOver);
					result.list.add(addition % 10);
					leftOver = addition / 10;				
				}
			result.isNegative = true;
			} else {
			
				lengthDiff = num1Size - num2Size;
				for (int i = num2Size; i >= 0; i--) {
					
					largeInt = list.get(i + lengthDiff);
					smallInt = argList.list.get(i);
					addition = largeInt + smallInt + leftOver;
					result.list.add(addition % 10);
					leftOver = addition / 10;
				}
	
				for (int i = lengthDiff - 1; i >= 0; i--) {
					addition = (list.get(i) + leftOver);
					result.list.add(addition % 10);
					leftOver = addition / 10;
				}
			}
		} else if (this.max(argList) == argList) {
			
			if (isNegative && !argList.isNegative) {

				isNegative = false;
				if (this.max(argList) == this) {
					result = (LinkedLargeInteger) this.subtract(argList);
					isNegative = true;
					result.isNegative = true;
					return result;
				} else {
					result = (LinkedLargeInteger) argList.subtract(this);
					isNegative = true;
					return result;
				}

			} else if (isNegative && argList.isNegative) {
				
				lengthDiff = num1Size - num2Size;
				for (int i = num2Size; i >= 0; i--) {
					
					smallInt = list.get(i + lengthDiff);
					largeInt = argList.list.get(i);
					addition = largeInt + smallInt + leftOver;
					result.list.add(addition % 10);
					leftOver = addition / 10;
				}
				for (int i = lengthDiff - 1; i >= 0; i--) {
					addition = (list.get(i) + leftOver);
					result.list.add(addition % 10);
					leftOver = addition / 10;				
				}
				result.isNegative = true;
			} else {
			
				lengthDiff = num2Size - num1Size;
				for (int i = num1Size; i >= 0; i--) {
					
					largeInt = list.get(i);
					smallInt = argList.list.get(i + lengthDiff);
					addition = largeInt + smallInt + leftOver;
					result.list.add(addition % 10);
					leftOver = addition / 10;
				}
				for (int i = lengthDiff - 1; i >= 0; i--) {
					addition = (argList.list.get(i) + leftOver);
					result.list.add(addition % 10);
					leftOver = addition / 10;
				}
			}
		} else {
			
			lengthDiff = num2Size - num1Size;
			for (int i = num1Size; i >= 0; i--) {
				
				largeInt = list.get(i);
				smallInt = argList.list.get(i + lengthDiff);
				addition = largeInt + smallInt + leftOver;
				result.list.add(addition % 10);
				leftOver = addition / 10;
			}
			for (int i = lengthDiff - 1; i >= 0; i--) {
				addition = (argList.list.get(i) + leftOver);
				result.list.add(addition % 10);
				leftOver = addition / 10;
			}
			
			if (isNegative && argList.isNegative) {
				result.isNegative = true;
			}
		}
		
		if (leftOver > 0) {
			result.list.add(leftOver);
		}
		
		Collections.reverse(result.list);
		return result;
	}

	/**
	 * Compares two LinkedLargeIntegers to see if they equal one another.
	 * @return boolean true if the LinkedLargeInteger equals the argument
	 */
	public boolean equals(LargeInteger num) {
		
		if ((this.toString().compareTo(num.toString())) == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Subtracts two large numbers from one another and outputs the result regardless
	 * of either one being negative or not.
	 * @return LargeInteger the result of the subtraction
	 */
	public LargeInteger subtract(LargeInteger num) {
		
		LinkedLargeInteger argList = new LinkedLargeInteger(num.toString());
		LinkedLargeInteger result = new LinkedLargeInteger("");
		int num1Size = list.size() - 1;
		int num2Size = argList.size() - 1;
		int largeInt;
		int smallInt;
		int lengthDiff;
		int difference = 0;
		int leftOver = 0;
				
		if (this.max(argList) == this) {

			if (isNegative && !argList.isNegative) {
				
				return this.negate().add(num);
			} else if (!isNegative && argList.isNegative) {
				
				return this.add(argList.negate());
			} else if (isNegative && argList.isNegative){
				
				lengthDiff = num2Size - num1Size;
				for (int i = num1Size; i >= 0; i--) {
					
					smallInt = list.get(i);
					largeInt = argList.list.get(i + lengthDiff);
					difference = largeInt - smallInt - leftOver;
	
					if (difference < 0) {
						difference += 10;
						leftOver = 1;
					} else {
						leftOver = 0;
					}
					result.list.add(difference);
				}
	
				for (int i = lengthDiff - 1; i >= 0; i--) {
					if (list.get(i) == 0 && leftOver > 0) {
						result.list.add(9);
						continue;
					}
					difference = list.get(i) - leftOver;
					if (difference > 0 || i > 0) {
						result.list.add(difference);
					}
					leftOver = 0;
				}
				result.isNegative = false;
			} else {
			
				lengthDiff = num1Size - num2Size;
				for (int i = num2Size; i >= 0; i--) {
					
					largeInt = list.get(i + lengthDiff);
					smallInt = argList.list.get(i);
					difference = largeInt - smallInt - leftOver;
	
					if (difference < 0) {
						difference += 10;
						leftOver = 1;
					} else {
						leftOver = 0;
					}
					result.list.add(difference);
				}
	
				for (int i = lengthDiff - 1; i >= 0; i--) {
					if (list.get(i) == 0 && leftOver > 0) {
						result.list.add(9);
						continue;
					}
					difference = list.get(i) - leftOver;
					if (difference > 0 || i > 0) {
						result.list.add(difference);
					}
					leftOver = 0;
				}
			}
		} else if (this.max(argList) == argList) {
			
			if (isNegative && !argList.isNegative) {
				
				return this.negate().add(argList).negate();
			} else if (isNegative && argList.isNegative) {
				
				lengthDiff = num1Size - num2Size;
				for (int i = num2Size; i >= 0; i--) {
					
					largeInt = list.get(i + lengthDiff);
					smallInt = argList.list.get(i);
					difference = largeInt - smallInt - leftOver;
	
					if (difference < 0) {
						difference += 10;
						leftOver = 1;
					} else {
						leftOver = 0;
					}
					result.list.add(difference);
				}
	
				for (int i = lengthDiff - 1; i >= 0; i--) {
					if (list.get(i) == 0 && leftOver > 0) {
						result.list.add(9);
						continue;
					}
					difference = list.get(i) - leftOver;
					if (difference > 0 || i > 0) {
						result.list.add(difference);
					}
					leftOver = 0;
				}
				result.isNegative = true;
			} else {
			
			lengthDiff = num2Size - num1Size;
			for (int i = num1Size; i >= 0; i--) {
				
				smallInt = list.get(i);
				largeInt = argList.list.get(i + lengthDiff);
				difference = largeInt - smallInt - leftOver;
				if (difference < 0) {
					difference += 10;
					leftOver = 1;
				} else {
					leftOver = 0;
				}
				result.list.add(difference);
			}
			
			for (int i = lengthDiff - 1; i >= 0; i--) {
				if (argList.list.get(i) == 0 && leftOver > 0) {
					result.list.add(9);
					continue;
				}
				difference = argList.list.get(i) - leftOver;
				if (difference > 0 || i > 0) {
					result.list.add(difference);
				}
				leftOver = 0;
			}
			result.isNegative = true;
			}
		} else {
			
			lengthDiff = num1Size - num2Size;
			for (int i = num2Size; i >= 0; i--) {
				
				largeInt = list.get(i + lengthDiff);
				smallInt = argList.list.get(i);
				difference = largeInt - smallInt - leftOver;

				if (difference < 0) {
					difference += 10;
					leftOver = 1;
				} else {
					leftOver = 0;
				}
				result.list.add(difference);
			}
		}

		Collections.reverse(result.list);
		return result;
	}

	/**
	 * Returns the negative of the LargeInteger
	 * @return LargeInteger the negative of the original LinkedLargeInteger
	 */
	public LargeInteger negate() {
		
		LinkedLargeInteger temp = new LinkedLargeInteger(this.toString());
		
		if (isNegative) {
			temp.isNegative = false;
		} else {
			temp.isNegative = true;
		}
		
		return temp;
	}

	/**
	 * Returns the absolute value of the LargeInteger
	 * @return LargeInteger the absolute value of the original LinkedLargeInteger
	 */
	public LargeInteger abs() {

		LinkedLargeInteger temp = new LinkedLargeInteger(this.toString());
		
		temp.isNegative = false;
		
		return temp;
	}

	/**
	 * Multiplies two LinkedLargeIntegers together
	 * @return LargeInteger the result of the multiplication
	 */
	public LargeInteger multiply(LargeInteger num) {
		LinkedLargeInteger argList = new LinkedLargeInteger(num.toString());
		LinkedLargeInteger result = new LinkedLargeInteger("");
		int num1Size = list.size();
		int num2Size = argList.size();
		int top = 0;
		int bottom = 0;
		int first;
		int second;
		result.list.add(0);
		
		if (argList.toString().equals("0") || this.toString().equals("0")) {
			result.list.add(0);
			result.isNegative = false;
			return result;
		}
		
		for (int i = num1Size - 1; i >= 0; i--) {
			bottom = 0;
			int leftOver = 0;
			first = list.get(i);
			
			for (int j = num2Size - 1; j >= 0; j--) {
				second = argList.list.get(j);
				int product = first * second;
				try {
					product += result.list.get(top + bottom) + leftOver;
				} catch (IndexOutOfBoundsException e) {
					product += leftOver;
				}
				leftOver = product / 10;
				try {
					result.list.set(top + bottom, product % 10);
				} catch (IndexOutOfBoundsException e) {
					result.list.add(product % 10);
				}
				
				bottom++;
			}
			if (leftOver > 0) {
				result.list.add(0);
				result.list.set(top + bottom, result.list.get(top + bottom) + leftOver);
			}
			top++;
		}
		
		if ((argList.isNegative && !isNegative) || (isNegative == true && !argList.isNegative)) {
			result.isNegative = true;
		} else if (isNegative && argList.isNegative) {
			result.isNegative = false;
		}
		Collections.reverse(result.list);
		return result;
	}

	/**
	 * Compares two LinkedLargeIntegers to find the larger of the two.
	 * @return LargeInteger the larger of the two LinkedLargeIntegers
	 */
	public LargeInteger max(LargeInteger num) {
		
		LinkedLargeInteger argList = new LinkedLargeInteger(num.toString());
		
		if ((!isNegative && argList.isNegative)) {
			return this;
		} else if ((isNegative && !argList.isNegative)) {
			return num;
		} else if (isNegative && argList.isNegative){
			
			if (this.size() < argList.size()) {
				return this;
			} else if (this.size() > argList.size()) {
				return num;
			}
			
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) < argList.list.get(i)) {
					return this;
				} else if (list.get(i) > argList.list.get(i)) {
					return num;
				}
			}
		} else {
		
			if (this.size() > argList.size()) {
				return this;
			} else if (this.size() < argList.size()) {
				return num;
			}
			
			for (int i = 0; i < list.size(); i++) {
				
				if (list.get(i) > argList.list.get(i)) {
					return this;
				} else if (list.get(i) < argList.list.get(i)) {
					return num;
				}
			}
		}
		return null;
	}

	/**
	 * Compares two LinkedLargeInteger to find the smaller of the two.
	 * @return LargeInteger the smaller of the two LinkedLargeInteger
	 */
	public LargeInteger min(LargeInteger num) {
		
		LinkedLargeInteger argList = new LinkedLargeInteger(num.toString());
		
		if ((!isNegative && argList.isNegative)) {
			return num;
		} else if ((isNegative && !argList.isNegative)) {
			return this;
		} else if (isNegative && argList.isNegative){
			
			if (list.size() < argList.size()) {
				return num;
			} else if (list.size() > argList.size()) {
				return this;
			}
			
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) < argList.list.get(i)) {
					return num;
				} else if (list.get(i) > argList.list.get(i)) {
					return this;
				}
			}
		} else {
		
			if (list.size() > argList.size()) {
				return num;
			} else if (list.size() < argList.size()) {
				return this;
			}
			
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) > argList.list.get(i)) {
					return num;
				} else if (list.get(i) < argList.list.get(i)) {
					return this;
				}
			}
		}
		return null;
	}

	/**
	 * Checks an LinkedLargeInteger to see if it's positive, negative,
	 * or equal to 0;
	 * @return int -1, 1, or 0 if the LinkedLargeInteger is either 
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
	 * Returns the size of the LinkedList
	 * @return int the size of the LinkedList
	 */
	public int size() {
		
		return list.size();
	}

}
