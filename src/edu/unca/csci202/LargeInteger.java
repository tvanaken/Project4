package edu.unca.csci202;

public interface LargeInteger<T> extends Comparable<T> {

	public T add(T num);
	
	public T subtract(T num);
	
	public T negate();
	
	public T abs();
	
	public T multiply(T num);
	
	public T max(T num);
	
	public T min(T num);
	
	public T signum(T num);
}
