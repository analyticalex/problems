package main.java.com.analyticalex.infixtopostfix;

public class Node<T> {
	private T value;
	private Node<T> LC;
	private Node<T> RC;
	
	public Node(T v) {
		value = v;
	}
	
	public void setLC(Node<T> l) {
		LC = l;
	}
	
	public void setRC(Node<T> r) {
		RC = r;
	}
	
	public Node<T> getLC() {
		return LC;
	}

	public Node<T> getRC() {
		return RC;
	}
	
	public T getValue() {
		return value;
	}
}
