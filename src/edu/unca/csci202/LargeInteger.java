package edu.unca.csci202;

public interface LargeInteger extends Comparable {

	Object array = null;
	boolean isNegative = false;

	public void add(String num);
	
	public void subtract(String num);
	
	public void negate();
	
	public LargeInteger abs();
	
	public void multiply(LargeInteger num);
	
	public LargeInteger max(LargeInteger num);
	
	public LargeInteger min(LargeInteger num);
	
	public int signum();

	public int size();
}
