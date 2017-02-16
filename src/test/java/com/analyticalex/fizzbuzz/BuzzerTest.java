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
	private final String newline = System.lineSeparator();

	// Set up Standard Out and Standard Error print streams before each test
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@Test
	public void printFullFizzBuzz() {	
		String[] args = {};
		Buzzer.main(args);	
		String expectedOut = 	"1" + newline +
								"2" + newline +
								"Fizz" + newline +
								"4" + newline +
								"Buzz" + newline +
								"Fizz" + newline +
								"7" + newline +
								"8" + newline +
								"Fizz" + newline +
								"Buzz" + newline +
								"11" + newline +
								"Fizz" + newline +
								"13" + newline +
								"14" + newline +
								"FizzBuzz" + newline +
								"16" + newline +
								"17" + newline +
								"Fizz" + newline +
								"19" + newline +
								"Buzz" + newline +
								"Fizz" + newline +
								"22" + newline +
								"23" + newline +
								"Fizz" + newline +
								"Buzz" + newline +
								"26" + newline +
								"Fizz" + newline +
								"28" + newline +
								"29" + newline +
								"FizzBuzz" + newline +
								"31" + newline +
								"32" + newline +
								"Fizz" + newline +
								"34" + newline +
								"Buzz" + newline +
								"Fizz" + newline +
								"37" + newline +
								"38" + newline +
								"Fizz" + newline +
								"Buzz" + newline +
								"41" + newline +
								"Fizz" + newline +
								"43" + newline +
								"44" + newline +
								"FizzBuzz" + newline +
								"46" + newline +
								"47" + newline +
								"Fizz" + newline +
								"49" + newline +
								"Buzz" + newline +
								"Fizz" + newline +
								"52" + newline +
								"53" + newline +
								"Fizz" + newline +
								"Buzz" + newline +
								"56" + newline +
								"Fizz" + newline +
								"58" + newline +
								"59" + newline +
								"FizzBuzz" + newline +
								"61" + newline +
								"62" + newline +
								"Fizz" + newline +
								"64" + newline +
								"Buzz" + newline +
								"Fizz" + newline +
								"67" + newline +
								"68" + newline +
								"Fizz" + newline +
								"Buzz" + newline +
								"71" + newline +
								"Fizz" + newline +
								"73" + newline +
								"74" + newline +
								"FizzBuzz" + newline +
								"76" + newline +
								"77" + newline +
								"Fizz" + newline +
								"79" + newline +
								"Buzz" + newline +
								"Fizz" + newline +
								"82" + newline +
								"83" + newline +
								"Fizz" + newline +
								"Buzz" + newline +
								"86" + newline +
								"Fizz" + newline +
								"88" + newline +
								"89" + newline +
								"FizzBuzz" + newline +
								"91" + newline +
								"92" + newline +
								"Fizz" + newline +
								"94" + newline +
								"Buzz" + newline +
								"Fizz" + newline +
								"97" + newline +
								"98" + newline +
								"Fizz" + newline +
								"Buzz" + newline;
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void print7to25FizzBuzz() {	
		String[] args = {"7","25"};
		Buzzer.main(args);
		String expectedOut = 	"7" + newline +
								"8" + newline +
								"Fizz" + newline +
								"Buzz" + newline +
								"11" + newline +
								"Fizz" + newline +
								"13" + newline +
								"14" + newline +
								"FizzBuzz" + newline +
								"16" + newline +
								"17" + newline +
								"Fizz" + newline +
								"19" + newline +
								"Buzz" + newline +
								"Fizz" + newline +
								"22" + newline +
								"23" + newline +
								"Fizz" + newline +
								"Buzz" + newline;
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void print77to84FizzBuzz() {	
		String[] args = {"77","84"};
		Buzzer.main(args);
		String expectedOut = 	"77" + newline +
								"Fizz" + newline +
								"79" + newline +
								"Buzz" + newline +
								"Fizz" + newline +
								"82" + newline +
								"83" + newline +
								"Fizz" + newline;
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void print3to3FizzBuzz() {	
		String[] args = {"3","3"};
		Buzzer.main(args);
		String expectedOut = 	"Fizz" + newline;
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void print30to30FizzBuzz() {	
		String[] args = {"30","30"};
		Buzzer.main(args);
		String expectedOut = 	"FizzBuzz" + newline;
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}
	
	@Test
	public void print19to19FizzBuzz() {	
		String[] args = {"19","19"};
		Buzzer.main(args);
		String expectedOut = 	"19" + newline;
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}
	
	@Test
	public void printErrorStartValGreaterThanEndVal() {	
		String[] args = {"35","20"};
		Buzzer.main(args);
		String expectedOut = "";
		String expectedErr = "Error: startVal must be less than or equal to endVal." + newline;
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void printErrorStartValNegative() {	
		String[] args = {"-2","10"};
		Buzzer.main(args);
		String expectedOut = "";
		String expectedErr = "Error: startVal and endVal must be positive." + newline;
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void printErrorOneIntArg() {	
		String[] args = {"30"};
		Buzzer.main(args);
		String expectedOut = "";
		String expectedErr = "Error: provide startVal and endVal, or omit arguments to default to 1 and 100." + newline;
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void printErrorMoreThanTwoIntArgs() {	
		String[] args = {"30","40","101"};
		Buzzer.main(args);
		String expectedOut = "";
		String expectedErr = "Error: provide startVal and endVal, or omit arguments to default to 1 and 100." + newline;
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void printErrorNonIntArgs() {	
		String[] args = {"text","string"};
		Buzzer.main(args);
		String expectedOut = "";
		String expectedErr = "Error: startVal and endVal must be integers." + newline;
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void printErrorThreeNonIntArgs() {	
		String[] args = {"true","text","string"};
		Buzzer.main(args);
		String expectedOut = "";
		String expectedErr = "Error: startVal and endVal must be integers." + newline;
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
