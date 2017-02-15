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
		String expectedOut = 	"1" + System.lineSeparator() +
								"2" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"4" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"7" + System.lineSeparator() +
								"8" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"11" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"13" + System.lineSeparator() +
								"14" + System.lineSeparator() +
								"FizzBuzz" + System.lineSeparator() +
								"16" + System.lineSeparator() +
								"17" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"19" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"22" + System.lineSeparator() +
								"23" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"26" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"28" + System.lineSeparator() +
								"29" + System.lineSeparator() +
								"FizzBuzz" + System.lineSeparator() +
								"31" + System.lineSeparator() +
								"32" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"34" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"37" + System.lineSeparator() +
								"38" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"41" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"43" + System.lineSeparator() +
								"44" + System.lineSeparator() +
								"FizzBuzz" + System.lineSeparator() +
								"46" + System.lineSeparator() +
								"47" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"49" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"52" + System.lineSeparator() +
								"53" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"56" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"58" + System.lineSeparator() +
								"59" + System.lineSeparator() +
								"FizzBuzz" + System.lineSeparator() +
								"61" + System.lineSeparator() +
								"62" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"64" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"67" + System.lineSeparator() +
								"68" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"71" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"73" + System.lineSeparator() +
								"74" + System.lineSeparator() +
								"FizzBuzz" + System.lineSeparator() +
								"76" + System.lineSeparator() +
								"77" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"79" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"82" + System.lineSeparator() +
								"83" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"86" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"88" + System.lineSeparator() +
								"89" + System.lineSeparator() +
								"FizzBuzz" + System.lineSeparator() +
								"91" + System.lineSeparator() +
								"92" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"94" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"97" + System.lineSeparator() +
								"98" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"Buzz" + System.lineSeparator();
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void print7to25FizzBuzz() {	
		String[] args = {"7","25"};
		Buzzer.main(args);
		String expectedOut = 	"7" + System.lineSeparator() +
								"8" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"11" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"13" + System.lineSeparator() +
								"14" + System.lineSeparator() +
								"FizzBuzz" + System.lineSeparator() +
								"16" + System.lineSeparator() +
								"17" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"19" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"22" + System.lineSeparator() +
								"23" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"Buzz" + System.lineSeparator();
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void print77to84FizzBuzz() {	
		String[] args = {"77","84"};
		Buzzer.main(args);
		String expectedOut = 	"77" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"79" + System.lineSeparator() +
								"Buzz" + System.lineSeparator() +
								"Fizz" + System.lineSeparator() +
								"82" + System.lineSeparator() +
								"83" + System.lineSeparator() +
								"Fizz" + System.lineSeparator();
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void print3to3FizzBuzz() {	
		String[] args = {"3","3"};
		Buzzer.main(args);
		String expectedOut = 	"Fizz" + System.lineSeparator();
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}

	@Test
	public void print30to30FizzBuzz() {	
		String[] args = {"3","3"};
		Buzzer.main(args);
		String expectedOut = 	"FizzBuzz" + System.lineSeparator();
		String expectedErr = "";
		assertEquals(expectedOut, outContent.toString());
		assertEquals(expectedErr, errContent.toString());
	}
	
	@Test
	public void print19to19FizzBuzz() {	
		String[] args = {"3","3"};
		Buzzer.main(args);
		String expectedOut = 	"19" + System.lineSeparator();
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
