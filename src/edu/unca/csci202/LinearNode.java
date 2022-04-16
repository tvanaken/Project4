package edu.unca.csci202;

public class LinearNode {
	private LinearNode next;
	private int element;

	/**
	 * Creates a node storing the specified element.
	 * @param elem element to be stored
	 */
	public LinearNode(int elem)
	{
		next = null;
		element = elem;
	}

	/**
	 * Returns the node that follows this one.
	 * @return reference to next node
	 */
	public LinearNode getNext()
	{
		return next;
	}

	/**
	 * Sets the node that follows this one.
	 * @param node node to follow this one
	 */
	public void setNext(LinearNode node)
	{
		next = node;
	}

	/**
	 * Returns the element stored in this node.
	 * @return element stored at the node
	 */
	public int getElement()
	{
		return element;
	}

	/**
	 * Sets the element stored in this node.
	 * @param elem element to be stored at this node
	 */
	public void setElement(int elem)
	{
		element = elem;
	}
}

