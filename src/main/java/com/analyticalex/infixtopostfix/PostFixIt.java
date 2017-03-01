package main.java.com.analyticalex.infixtopostfix;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

/**
 * Class used to convert an arithmetic string from infix notation to postfix notation.
 * 
 * The main method takes a single argument, an arithmetic string in valid infix notation.
 * The string is converted to postfix notation according to standard order of operations
 * for infix notation, then printed to standard output.
 * 
 * If a single string is not provided, or the string is not an arithmetic expression
 * in valid infix notation, an error message will be printed to standard error.
 * 
 * This class supports operators *, /, +, and -; operands which are numbers represented
 * as strings of digits 0-9; and parenthesis ( and ) which may be used to group operands 
 * and operators.
 * 
 * @author analyticalex
 */
public class PostFixIt {

	public static void main(String[] args) throws NoSuchElementException, InvalidInfixException
	{
		// Check for single string argument
		if (args.length != 1) {
			System.err.println("Error: Invalid input. Please provide one argument, an arithmetic string in valid infix notation.");
			return;
		}
		
		try {
			
			Node<String> root = processInfix(args[0]); // Process string input into operator tree
			printPostFix(root); // Print postfix notation from operator tree
			
		} catch (NoSuchElementException e) {
			System.err.println("Error: Invalid input. Arithmetic string in not in valid infix notation.");
			return;
		} catch (InvalidInfixException ie) {
			System.err.println("Error: Invalid input. Arithmetic string in not in valid infix notation.");
			return;
		}
	}

	/**
	 * Method to process an arithmetic string in infix notation to an operator tree.
	 * 
	 * An operator tree is a binary tree. Every leaf is a number. Every operator has 
	 * exactly two children. The children of an operator represent the two values the 
	 * operator acts on. Each child of an operator can be either a single number, or
	 * an operator which serves as the root of a subtree representing the result
	 * of one or more operations on multiple numbers.
	 * 
	 * The tree is built according to standard order of operations for infix notation.
	 * 
	 * @param s	Arithmetic string in infix notation.
	 * @return Root of operator tree.
	 */
	private static Node<String> processInfix(String s) {
		
		// Trim leading whitespace and split into tokens
		s = s.trim();
		String splitstr = "\\s+" + "|"					// whitespace i.e. "3 "
				+ "(?<=[*/+-[\\(\\)]])(?=\\d)" + "|"	// operator or paren followed by digit i.e. "+7" or "(5"
				+ "(?<=\\d)(?=[*/+-[\\(\\)]])" + "|"	// digit followed by operator or paren i.e. "8/" or "6)"
				+ "(?<=[*/+-])(?=[\\(\\)])" + "|"		// operator followed by paren i.e. "+("
				+ "(?<=[\\(\\)])(?=[*/+-])" + "|"		// paren followed by operator i.e. ")/"
				+ "(?<=[\\(])(?=[\\(])" + "|"			// left paren followed by left paren i.e. "(("
				+ "(?<=[\\)])(?=[\\)])";				// right paren followed by right paren i.e. "))"
		String[] tokens = s.split(splitstr);
	
		ArrayDeque<Node<String>> nodes = new ArrayDeque<Node<String>>();

		for (int i = 0; i < tokens.length; i++) {
			Node<String> n = new Node<String>(tokens[i]); // Create node from token
			
			// If node represents end of parenthetical, pop from nodes until 
			// reaching beginning of parenthetical, add each node to nodesSubset, 
			// and generate subtree from nodesSubset
			if (n.getValue().equals(")")) {
				
				ArrayDeque<Node<String>> nodesSubset = new ArrayDeque<Node<String>>();

				// Note: NoSuchElementException thrown here indicates we are seeking left paren that
				// does not exist, so string input was not in valid infix notation
				Node<String> nPop = nodes.removeFirst();
				while (true) {
					if (nPop.getValue().equals("(")) {
						break;
					}
					nodesSubset.addLast(nPop);		
					nPop = nodes.removeFirst();
				}	
				// Send node subset from parenthetical to be evaluated based on *, /, +, - operators
				n = MDAS(nodesSubset);
			}
			nodes.addFirst(n);
		}
		
		// By now, all parentheticals should be processed. Send for final evaluation based on  *, /, +, - operators
		Node<String> root = MDAS(nodes);
		return root;
	}
	
	/**
	 * Method to create operator tree from collection of nodes containing only numbers and operators *, /, +, -.
	 * 
	 * @param nodes	DEQ of nodes containing no parenthesis
	 * @return Root of operator (sub)tree.
	 */
	private static Node<String> MDAS(ArrayDeque<Node<String>> nodes) {
		
		// Order of operations states, evaluate * and / from left to right, then + and - from left to right
		nodes = operate(nodes, "*", "/");
		nodes = operate(nodes, "+", "-");
		
		// If more than a single node is left in the deq, string input was not in valid infix notation
		if (nodes.size() != 1) {
			throw new InvalidInfixException();
		}
		
		return nodes.getFirst();
	}
	
	/**
	 * Method to create operator tree from collection of nodes containing only numbers and a pair of operators.
	 * 
	 * @param nodes	Nodes from which operator tree will be created
	 * @param operator1
	 * @param operator2
	 * @return	Nodes list with operands of operator type operator1 and operator2 removed, present instead as children of their operator
	 */
	private static ArrayDeque<Node<String>> operate(ArrayDeque<Node<String>> nodes, String operator1, String operator2) {

		ArrayDeque<Node<String>> newNodes = new ArrayDeque<Node<String>>();
		
		while (!nodes.isEmpty()) {
			Node<String> n = nodes.removeLast();
			
			// Nodes are simply added to newNodes, unless they are an operand of operator type operator1 or operator2
			// Then, they are added as children of their operator, rather than listed in newNodes
			if (n.getLC() == null && n.getRC() == null && (n.getValue().equals(operator1) || n.getValue().equals(operator2))) {
				Node<String> l = newNodes.removeFirst();
				Node<String> r = nodes.removeLast();
				n.setLC(l);
				n.setRC(r);
			}		
			newNodes.addFirst(n);
		}
		
		return newNodes;
	}
	
	/**
	 * Calls PostFixIt#printPostFix(Node, String) to generate string representation
	 * of operator tree with root n, then prints the string.
	 * 
	 * @see PostFixIt#printPostFix(Node, String)
	 * @param n	Root of operator tree.
	 */
	private static void printPostFix(Node<String> n) {
		String postfix = printPostFix(n, "");
		System.out.println(postfix);
	}
	
	/**
	 * Method to generate the postfix notation string representation of an operator tree
	 * via postorder depth-first traversal of tree.
	 * 
	 * Given the root of an operator (sub)tree, and the string representation of the tree
	 * generated earlier in the depth-first traversal, this method converts the operator
	 * (sub)tree into a string in postfix notation, and appends it to the existing expression.
	 * 
	 * @param n	Root of operator (sub)tree.
	 * @param s	Arithmetic expression generated so far in tree traversal
	 * @return	Arithmetic expression which includes representation of the subtree at n
	 */
	private static String printPostFix(Node<String> n, String s) {
		if (n == null) {
			return s;
		}
		
		if (n.getLC() != null) {
			s = printPostFix(n.getLC(), s);
		}
		if (n.getRC() != null) {
			s = printPostFix(n.getRC(), s);
		}
		
		if (s.isEmpty()) {
			s = n.getValue();
		} else {
			s += " " + n.getValue();
		}
		return s;
	}
}