package main.java.com.analyticalex.fizzbuzz;

public class Buzzer {

	public static void main(String[] args) 
	{
		// Default values
		int startVal = 1;
		int endVal = 100;

		// Validate input
		
		// Check: zero or two arguments
		if (args.length != 0 && args.length != 2) 
		{
			System.err.println("Error: provide startVal and endVal, or omit arguments to default to 1 and 100.");
			return;
		}
		
		if (args.length == 2)
		{
			// Check: arguments are integers
			try { 
		        startVal = Integer.parseInt(args[0]); 
		        endVal = Integer.parseInt(args[1]);
		    } catch(NumberFormatException e) { 
		    	System.err.println("Error: startVal and endVal must be integers.");
				return;
		    }
			
			// Check: arguments must be positive
			if (startVal <= 0 || endVal <= 0)
			{
				System.err.println("Error: startVal and endVal must be positive.");
				return;
			}
			
			// Check: startVal must be less than or equal to endVal
			if (startVal > endVal)
			{
				System.err.println("Error: startVal must be less than or equal to endVal.");
				return;
			}
		}

		printFizzBuzz(startVal, endVal);
	}
	
	/**
	 * Prints integers to standard output, beginning with startVal
	 * and ending with endVal, inclusive. For multiples of 3, "Fizz"
	 * is printed instead of the number. For multiples of 5, "Buzz"
	 * is printed instead of the number. For multiples of 3 and 5,
	 * "FizzBuzz" is printed instead of the number. The output for
	 * each integer is followed by a line break.
	 * 
	 * Integer range must be positive and increasing. That is, startVal 
	 * must be positive, and less than or equal to endVal.
	 * 
	 * @param startVal	starting value of integer count
	 * @param endVal	ending value of integer count
	 */
	private static void printFizzBuzz(int startVal, int endVal)
	{
		for (int i = startVal; i < endVal+1; i++)
		{
			String nxt = "";
			Boolean xthree = false;
			Boolean xfive = false;
			
			// Check if integer divisible by 3
			if (i % 3 == 0)
			{
				nxt += "Fizz";
				xthree = true;
			}
			
			// Check if integer divisible by 5
			if (i % 5 == 0)
			{
				nxt += "Buzz";
				xfive = true;
			}
			
			// If integer divisible by 3, 5, or both, print text instead
			if (xthree || xfive)
			{
				System.out.println(nxt);
			}
			else
			{
				System.out.println(i);
			}
		}
	}

}
