package test.java.com.analyticalex.infixtopostfix;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.com.analyticalex.infixtopostfix.PostFixIt;

public class PostFixItTest {

	//To enable JUnit tests on Standard Out and Standard Err
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final String newline = System.lineSeparator();
	
	@Before
	public void setUpStreams()
	{
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	@Test
	public void testValidInput01()
	{
		String[] args = {"3+4"};
		PostFixIt.main(args);
		String expectedOut = "3 4 +" + newline;
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}
	
	@Test
	public void testValidInput01WithSpace()
	{
		String[] args = {"   3	+ 4 "};
		PostFixIt.main(args);
		String expectedOut = "3 4 +" + newline;
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}
	
	@Test
	public void testValidInput02()
	{
		String[] args = {"(3 + 4)/7"};
		PostFixIt.main(args);
		String expectedOut = "3 4 + 7 /" + newline;
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());		
	}
	
	@Test
	public void testValidInput03()
	{
		String[] args = {"5 * (3+6 )	/ (2 + 1)"};
		PostFixIt.main(args);
		String expectedOut = "5 3 6 + * 2 1 + /" + newline;
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}
	
	@Test
	public void testValidInput04()
	{
		String[] args = {"( (8/4) /2)*(9 - 3)"};
		PostFixIt.main(args);
		String expectedOut = "8 4 / 2 / 9 3 - *" + newline;
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}
	
	@Test
	public void testNoArgs()
	{
		String[] args = {};
		PostFixIt.main(args);
		String expectedOut = "";
		String expectedErr = "Error: Invalid input. Please provide one argument, an arithmetic string in valid postfix notation." + newline;
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}
	
	@Test
	public void testMultipleArgs()
	{
		String[] args = {" 3  + ", "4 / 2"};
		PostFixIt.main(args);
		String expectedOut = "";
		String expectedErr = "Error: Invalid input. Please provide one argument, an arithmetic string in valid postfix notation." + newline;
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}
	
	@Test
	public void testInvalidInput01()
	{
		String[] args = {"5 + "};
		PostFixIt.main(args);
		String expectedOut = "";
		String expectedErr = "Error: Invalid input. Please provide one argument, an arithmetic string in valid postfix notation." + newline;
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}
	
	@After
	public void cleanUpStreams()
	{
		System.setOut(null);
		System.setErr(null);
	}

}