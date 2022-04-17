package edu.unca.csci202;

/**
 * The LargeInteger provides methods for adding, subtracting, multiplication,
 * as well as ways to compare two LargeIntegers.
 * @author Taylor Van Aken
 */
public interface LargeInteger extends Comparable<Object> {

	/**
	 * Adds two LargeIntegers together and outputs the result regardless
	 * of either one being negative or not.
	 * @return LargeInteger the result of the addition
	 */
	public LargeInteger add(LargeInteger num);
	
	/**
	 * Compares two LargeIntegers to see if they equal one another.
	 * @return boolean true if the LargeIntegers equals the argument
	 */
	public boolean equals(LargeInteger num);
	
	/**
	 * Subtracts two LargeIntegers from one another and outputs the result regardless
	 * of either one being negative or not.
	 * @return LargeInteger the result of the subtraction
	 */
	public LargeInteger subtract(LargeInteger num);
	
	/**
	 * Returns the negative of the LargeInteger
	 * @return LargeInteger the negative of the original LargeInteger
	 */
	public LargeInteger negate();
	
	/**
	 * Returns the absolute value of the LargeInteger
	 * @return LargeInteger the absolute value of the original LargeInteger
	 */
	public LargeInteger abs();
	
	/**
	 * Multiplies two LargeIntegers together
	 * @return LargeInteger the result of the multiplication
	 */
	public LargeInteger multiply(LargeInteger num);
	
	/**
	 * Compares two LargeIntegers to find the larger of the two.
	 * @return LargeInteger the larger of the two LargeIntegers
	 */
	public LargeInteger max(LargeInteger num);
	
	/**
	 * Compares two LargeIntegers to find the smaller of the two.
	 * @return LargeInteger the smaller of the two LargeIntegers
	 */
	public LargeInteger min(LargeInteger num);
	
	/**
	 * Checks an LargeIntegers to see if it's positive, negative,
	 * or equal to 0;
	 * @return int -1, 1, or 0 if the LargeIntegers is either 
	 * negative, positive, or equal to 0
	 */
	public int signum();

	/**
	 * Returns the size of the LargeInteger
	 * @return int the size of the LargeInteger
	 */
	public int size();
}
