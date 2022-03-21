package edu.unca.csci202;

public interface LargeInteger<T> extends Comparable<T> {

	public void add(String num);
	
	public void subtract(String num);
	
	public void negate();
	
	public T abs();
	
	public void multiply(T num);
	
	public LargeInteger<T> max(String num);
	
	public LargeInteger<T> min(String num);
	
	public int signum();
}
