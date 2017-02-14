package test.java.com.analyticalex.fizzbuzz;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.com.analyticalex.fizzbuzz.Buzzer;

public class BuzzerTest {

	// To enable JUnit tests on Standard Out and Standard Error
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	// Set up Standard Out and Standard Error print streams before each test
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@Test
	public void printFullFizzBuzz() {	
		String[] args = null;
		Buzzer.main(args);	
		String expectedOut = 	"1\n" +
								"2\n" +
								"Fizz\n" +
								"4\n" +
								"Buzz\n" +
								"Fizz\n" +
								"7\n" +
								"8\n" +
								"Fizz\n" +
								"Buzz\n" +
								"11\n" +
								"Fizz\n" +
								"13\n" +
								"14\n" +
								"FizzBuzz\n" +
								"16\n" +
								"17\n" +
								"Fizz\n" +
								"19\n" +
								"Buzz\n" +
								"Fizz\n" +
								"22\n" +
								"23\n" +
								"Fizz\n" +
								"Buzz\n" +
								"26\n" +
								"Fizz\n" +
								"28\n" +
								"29\n" +
								"FizzBuzz\n" +
								"31\n" +
								"32\n" +
								"Fizz\n" +
								"34\n" +
								"Buzz\n" +
								"Fizz\n" +
								"37\n" +
								"38\n" +
								"Fizz\n" +
								"Buzz\n" +
								"41\n" +
								"Fizz\n" +
								"43\n" +
								"44\n" +
								"FizzBuzz\n" +
								"46\n" +
								"47\n" +
								"Fizz\n" +
								"49\n" +
								"Buzz\n" +
								"Fizz\n" +
								"52\n" +
								"53\n" +
								"Fizz\n" +
								"Buzz\n" +
								"56\n" +
								"Fizz\n" +
								"58\n" +
								"59\n" +
								"FizzBuzz\n" +
								"61\n" +
								"62\n" +
								"Fizz\n" +
								"64\n" +
								"Buzz\n" +
								"Fizz\n" +
								"67\n" +
								"68\n" +
								"Fizz\n" +
								"Buzz\n" +
								"71\n" +
								"Fizz\n" +
								"73\n" +
								"74\n" +
								"FizzBuzz\n" +
								"76\n" +
								"77\n" +
								"Fizz\n" +
								"79\n" +
								"Buzz\n" +
								"Fizz\n" +
								"82\n" +
								"83\n" +
								"Fizz\n" +
								"Buzz\n" +
								"86\n" +
								"Fizz\n" +
								"88\n" +
								"89\n" +
								"FizzBuzz\n" +
								"91\n" +
								"92\n" +
								"Fizz\n" +
								"94\n" +
								"Buzz\n" +
								"Fizz\n" +
								"97\n" +
								"98\n" +
								"Fizz\n" +
								"Buzz\n";
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void print7to25FizzBuzz() {	
		String[] args = {"7","25"};
		Buzzer.main(args);
		String expectedOut = 	"7\n" +
								"8\n" +
								"Fizz\n" +
								"Buzz\n" +
								"11\n" +
								"Fizz\n" +
								"13\n" +
								"14\n" +
								"FizzBuzz\n" +
								"16\n" +
								"17\n" +
								"Fizz\n" +
								"19\n" +
								"Buzz\n" +
								"Fizz\n" +
								"22\n" +
								"23\n" +
								"Fizz\n" +
								"Buzz\n";
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void print77to84FizzBuzz() {	
		String[] args = {"77","84"};
		Buzzer.main(args);
		String expectedOut = 	"77\n" +
								"Fizz\n" +
								"79\n" +
								"Buzz\n" +
								"Fizz\n" +
								"82\n" +
								"83\n" +
								"Fizz\n";
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void printErrorStartValGreaterThanEndVal() {	
		String[] args = {"35","20"};
		Buzzer.main(args);
		String expectedOut = "";
		String expectedErr = "Error: startVal must be less than or equal to endVal.";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void printErrorStartValNegative() {	
		String[] args = {"-2","10"};
		Buzzer.main(args);
		String expectedOut = "";
		String expectedErr = "Error: startVal must be positive.";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void printErrorOneIntArg() {	
		String[] args = {"30"};
		Buzzer.main(args);
		String expectedOut = "";
		String expectedErr = "Error: provide both startVal and endVal, or omit arguments to default to 1 and 100.";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void printErrorMoreThanTwoIntArgs() {	
		String[] args = {"30","40","101"};
		Buzzer.main(args);
		String expectedOut = "";
		String expectedErr = "Error: provide only startVal and endVal, or omit arguments to default to 1 and 100.";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void printErrorNonIntArgs() {	
		String[] args = {"text","string"};
		Buzzer.main(args);
		String expectedOut = "";
		String expectedErr = "Error: startVal and endVal must be integers.";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void printErrorThreeNonIntArgs() {	
		String[] args = {"true","text","string"};
		Buzzer.main(args);
		String expectedOut = "";
		String expectedErr = "Error: startVal and endVal must be integers.";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	// Clean up print streams to prepare for next test
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
}
