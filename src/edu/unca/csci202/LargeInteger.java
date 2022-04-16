package edu.unca.csci202;

public interface LargeInteger extends Comparable<Object> {

	public LargeInteger add(LargeInteger num);
	
	public boolean equals(LargeInteger num);
	
	public LargeInteger subtract(LargeInteger num);
	
	public LargeInteger negate();
	
	public LargeInteger abs();
	
	public void multiply(LargeInteger num);
	
	public LargeInteger max(LargeInteger num);
	
	public LargeInteger min(LargeInteger num);
	
	public int signum();

	public int size();
}
