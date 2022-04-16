package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedLargeInteger implements LargeInteger {

	private LinkedList<Integer> list;
	boolean isNegative = false;
	
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
	
	@Override
	public int compareTo(Object num) {
		
		LinkedLargeInteger temp = new LinkedLargeInteger(num.toString());
		
		if (this.max(temp) == this) {
			return 1;
		} else if (this.max(temp) == temp) { 
			return -1;
		}
		return 0;
	}

	@Override
	public LargeInteger add(LargeInteger num) {


		LinkedLargeInteger argList = new LinkedLargeInteger(num.toString());
		LinkedList<Integer> result = new LinkedList<Integer>();
		int num1Size = list.size() - 1;
		int num2Size = argList.size() - 1;
		int largeInt;
		int smallInt;
		int lengthDiff;
		int addition = 0;
		int leftOver = 0;
		
		if (this.max(argList) == this) {
			
			if (isNegative && !argList.isNegative) {
				
				this.subtract(num);
				isNegative = true;
				return this;
			} else if (!isNegative && argList.isNegative) {
				
				argList.isNegative = false;
				this.subtract(argList);
				return this;
			} else if (isNegative && argList.isNegative) {
				
				lengthDiff = num2Size - num1Size;
				for (int i = num1Size; i >= 0; i--) {
					
					largeInt = list.get(i);
					smallInt = argList.list.get(i + lengthDiff);
					addition = largeInt + smallInt + leftOver;
					result.add(addition % 10);
					leftOver = addition / 10;
				}
	
				for (int i = lengthDiff - 1; i >= 0; i--) {
					addition = (list.get(i) + leftOver);
					result.add(addition % 10);
					leftOver = addition / 10;				}
			} else {
			
				lengthDiff = num1Size - num2Size;
				for (int i = num2Size; i >= 0; i--) {
					
					largeInt = list.get(i + lengthDiff);
					smallInt = argList.list.get(i);
					addition = largeInt + smallInt + leftOver;
					result.add(addition % 10);
					leftOver = addition / 10;
				}
	
				for (int i = lengthDiff - 1; i >= 0; i--) {
					addition = (list.get(i) + leftOver);
					result.add(addition % 10);
					leftOver = addition / 10;
				}
			}
		} else if (this.max(argList) == argList) {
			
			if (isNegative && !argList.isNegative) {
				
				isNegative = false;
				if (this.max(argList) == this) {
					this.subtract(argList);
					isNegative = true;
					return this;
				} else {
					this.subtract(argList);
					isNegative = false;
					return this;
				}
				
			} else if (isNegative && argList.isNegative) {
				
				lengthDiff = num1Size - num2Size;
				for (int i = num2Size; i >= 0; i--) {
					
					smallInt = list.get(i + lengthDiff);
					largeInt = argList.list.get(i);
					addition = largeInt + smallInt + leftOver;
					result.add(addition % 10);
					leftOver = addition / 10;
				}
				for (int i = lengthDiff - 1; i >= 0; i--) {
					addition = (argList.list.get(i) + leftOver);
					result.add(addition % 10);
					leftOver = addition / 10;				
				}
			} else {
			
				lengthDiff = num2Size - num1Size;
				for (int i = num1Size; i >= 0; i--) {
					
					largeInt = list.get(i);
					smallInt = argList.list.get(i + lengthDiff);
					addition = largeInt + smallInt + leftOver;
					result.add(addition % 10);
					leftOver = addition / 10;
				}
				for (int i = lengthDiff - 1; i >= 0; i--) {
					addition = (argList.list.get(i) + leftOver);
					result.add(addition % 10);
					leftOver = addition / 10;
				}
			}
		} else {
			
			lengthDiff = num2Size - num1Size;
			for (int i = num1Size; i >= 0; i--) {
				
				largeInt = list.get(i);
				smallInt = argList.list.get(i + lengthDiff);
				addition = largeInt + smallInt + leftOver;
				result.add(addition % 10);
				leftOver = addition / 10;
			}
			for (int i = lengthDiff - 1; i >= 0; i--) {
				addition = (argList.list.get(i) + leftOver);
				result.add(addition % 10);
				leftOver = addition / 10;
			}
		}
		
		if (leftOver > 0) {
			result.add(leftOver);
		}
		
		Collections.reverse(result);
		list = result;
		return this;
	}

	@Override
	public boolean equals(LargeInteger num) {
		
		if ((this.toString().compareTo(num.toString())) == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public LargeInteger subtract(LargeInteger num) {
		
		LinkedLargeInteger argList = new LinkedLargeInteger(num.toString());
		LinkedList<Integer> result = new LinkedList<Integer>();
		int num1Size = list.size() - 1;
		int num2Size = argList.size() - 1;
		int largeInt;
		int smallInt;
		int lengthDiff;
		int difference = 0;
		int leftOver = 0;
				
		if (this.max(argList) == this) {

			if (isNegative && !argList.isNegative) {

				isNegative = false;
				
				this.add(num);
				return this;
			} else if (!isNegative && argList.isNegative) {
				
				argList.isNegative = false;
				this.add(argList);
				isNegative = false;
				return this;
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
					result.add(difference);
				}
	
				for (int i = lengthDiff - 1; i >= 0; i--) {
					if (list.get(i) == 0 && leftOver > 0) {
						result.add(9);
						continue;
					}
					difference = list.get(i) - leftOver;
					if (difference > 0 || i > 0) {
						result.add(difference);
					}
					leftOver = 0;
				}
				isNegative = false;
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
					result.add(difference);
				}
	
				for (int i = lengthDiff - 1; i >= 0; i--) {
					if (list.get(i) == 0 && leftOver > 0) {
						result.add(9);
						continue;
					}
					difference = list.get(i) - leftOver;
					if (difference > 0 || i > 0) {
						result.add(difference);
					}
					leftOver = 0;
				}
			}
		} else if (this.max(argList) == argList) {
			
			if (isNegative && !argList.isNegative) {
				
				isNegative = false;
				this.add(argList);
				isNegative = true;
				return this;
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
					result.add(difference);
				}
	
				for (int i = lengthDiff - 1; i >= 0; i--) {
					if (list.get(i) == 0 && leftOver > 0) {
						result.add(9);
						continue;
					}
					difference = list.get(i) - leftOver;
					if (difference > 0 || i > 0) {
						result.add(difference);
					}
					leftOver = 0;
				}
				isNegative = true;
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
				result.add(difference);
			}
			
			for (int i = lengthDiff - 1; i >= 0; i--) {
				if (argList.list.get(i) == 0 && leftOver > 0) {
					result.add(9);
					continue;
				}
				difference = argList.list.get(i) - leftOver;
				if (difference > 0 || i > 0) {
					result.add(difference);
				}
				leftOver = 0;
			}
			isNegative = true;
			}
		}

		Collections.reverse(result);
		list = result;
		return this;
	}

	@Override
	public LargeInteger negate() {
		
		LinkedLargeInteger temp = new LinkedLargeInteger(this.toString());
		
		temp.isNegative = true;
		
		return temp;
	}

	@Override
	public LargeInteger abs() {

		LinkedLargeInteger temp = new LinkedLargeInteger(this.toString());
		
		temp.isNegative = false;
		
		return temp;
	}

	@Override
	public void multiply(LargeInteger num) {
		LinkedLargeInteger argList = new LinkedLargeInteger(num.toString());
		LinkedList<Integer> result = new LinkedList<Integer>();
		int num1Size = list.size();
		int num2Size = argList.size();
		int top = 0;
		int bottom = 0;
		int first;
		int second;
		result.add(0);
		
		if (argList.toString().equals("0") || this.toString().equals("0")) {
			list = result;
			isNegative = false;
			return;
		}
		
		for (int i = num1Size - 1; i >= 0; i--) {
			bottom = 0;
			int leftOver = 0;
			first = list.get(i);
			
			for (int j = num2Size - 1; j >= 0; j--) {
				second = argList.list.get(j);
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
		
		if ((argList.isNegative && !isNegative) || (isNegative == true && !argList.isNegative)) {
			isNegative = true;
		} else if (isNegative && argList.isNegative) {
			isNegative = false;
		}
		Collections.reverse(result);
		list = result;
	}

	@Override
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

	@Override
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

	@Override
	public int signum() {

		if (isNegative) {
			return -1;
		} else if (this.toString().charAt(0) == '0') {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int size() {
		
		return list.size();
	}

}
