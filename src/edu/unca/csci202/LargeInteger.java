package edu.unca.csci202;

public interface LargeInteger extends Comparable<Object> {

	public void add(String num);
	
	public boolean equals(Object num);
	
	public void subtract(String num);
	
	public void negate();
	
	public void abs();
	
	public void multiply(String num);
	
	public LargeInteger max(LargeInteger num);
	
	public LargeInteger min(LargeInteger num);
	
	public int signum();

	public int size();
}
