package edu.unca.csci202;

public interface LargeInteger<T> extends Comparable<T> {

	public void add(String num);
	
	public void subtract(String num);
	
	public void negate();
	
	public T abs();
	
	public void multiply(T num);
	
	public LargeInteger<T> max(LargeInteger<T> num);
	
	public LargeInteger<T> min(LargeInteger<T> num);
	
	public int signum();
}
