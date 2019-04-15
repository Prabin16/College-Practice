import java.util.ArrayList;

/**
 * Program Name: Methods.java 
 * Purpose: This file contains all the methods required for the project file. 
 * 						Here exists seven methods 
 * 							1. First Method is to remove the last entry of arraylist, which takes array list as an argument and returns nothing 
 * 							2. Second method is to calculate HST at the rate of 13% 
 * 							3. Third method takes two arguments: total amount before tax and tax, and returns grand total rounded to nearest nickel. 
 * 							4. Fourth method is to calculate change assuming that 100$ and 50$ bills are not accepted. 
 * 							*************Methods 5,6,7 were not required for the project*********************
 * 							5. Fifth method is to return the round value of entered double value to 2 place 
 * 							6. Sixth Method is to check if the given double has just two or less decimals
 * 							7. Last method is to check if the given string holds the proper double value
 * 								[NOTE: THIS FILE DOES NOT EXECUTE ALONE, AS IT DOES NOT HAVE MAIN CLASS]
 * Coder: Prabin Gyawali 877282 
 * Date: Mar 15, 2019
 */

public class Methods
{

	/**
	 * Method Name: removeLastEntry()<br>
	 * Purpose: a public class void method that removes the last value in the array list<br>
	 * Accepts: an array list of type double<br>
	 * Returns: nothing as the method is void and the argument passed is by reference,<br> 
	 * 					so the removing of last entry is done to the original array list<br>
	 * Coder: Prabin Gyawali 
	 * Date: Mar 15, 2019
	 */
	public static void removeLastEntry(ArrayList<Double> arrayListArgument)
	{
		// simply removes the last element of the arrayList which is passed through argument
		arrayListArgument.remove(arrayListArgument.size() - 1);// index of last element is one less than the size of the list.
	}// End of method removeLastEntry()

	/**
	 * Method Name: calculateHST()<br>
	 * Purpose: to calculate Harmonized Sales Tax (HST) from given amount<br>
	 * Accepts: one double variable holding the value of amount passed<br>
	 * Returns: a double that is the HST of passed value<br>
	 * Coder: Prabin Gyawali 
	 * Date: Mar 15, 2019
	 */
	public static double calculateHST(double amount)
	{
		final double HST_RATE = 0.13;// set a constant HST which is equal to 13% that is 0.13
		double taxAmount = HST_RATE * amount;// calculate the tax by multiplying tax rate by the amount which is passed through argument
		return round(taxAmount);// returns the rounded tax amount
	}// End of method calculateHST

	/**
	 * Method Name: totalOwiningToNearestFive()<br>
	 * Purpose: To calculate the grand total and round it to nearest nickel<br>
	 * Accepts: two double values representing amount and taxAmount<br>
	 * Returns: a double that is the sum of amount and taxAmount which is rounded to nearest nickel<br>
	 * Coder: Prabin Gyawali 
	 * Date: Mar 15, 2019
	 */
	public static double totalOwiningToNearestFive(double amount, double taxAmount)
	{
		double totalAmount = amount + taxAmount;// create a variable total amount which holds the sum of two variables passed through arguments
		totalAmount = (int) ((totalAmount * 100) + 0.5);// multiplies total amount by 100 and store it so that the price is changed from dollar to cents
		int nearestFive;		
		nearestFive = ((int) totalAmount) % 5;// divide the cents money by 5 and store the reminder checks the condition for the reminder generated
		switch (nearestFive)
		{
		case 1: case 2:
			totalAmount = totalAmount - nearestFive;// subtract it from total cent if the remaining cent is 1 or 2
			break;
		case 3:	case 4:
			totalAmount = totalAmount + (5 - nearestFive);// if the remaining cents is 3 or 4 add 2 or 1 to total amount
			break;
		}// End Switch
		totalAmount /= 100;// divide the total amount by 100, so that the value is again converted to dollars.
		return totalAmount; // return the final fotalAmount
	}// End of method totalOwiningToNearestFive

	/**
	 * Method Name: calculateChange()<br>
	 * Purpose: calculate change of two total amount and user cash.<br>
	 * Accepts: Two double values which stores total amount and user cash<br>
	 * Returns: A string value which stores all the change that need to be returned.<br>
	 * 					Change is the combination of $10,$5,$2,$1, 25 cent, 10 cent and 5 cent
	 * Coder: Prabin Gyawali 
	 * Date: Mar 15, 2019
	 */
	public static String calculateChange(double totalAmount, double userCash)
	{
		// CREATE CONSTANT VALUES TO STORE THE DOLLARS AND CENTS VALUE
		final int TEN_DOLLAR = 10;
		final int FIVE_DOLLAR = 5;
		final int TWO_DOLLAR = 2;
		final int ONE_DOLLAR = 1;
		final int TWENTYFIVE_CENTS = 25;
		final int TEN_CENTS = 10;
		final int FIVE_CENTS = 5;

		// create a difference variable which stores the difference of cash paid by user and the total bill, both of which are passed through arguments
		double difference = userCash - totalAmount;

		// create two integer variables to store total dollar and remaining cents of the difference
		//[NOTE: Here dollar holds the dollar part and cent holds the cent part of the difference as integer
		//				Example: if difference is 50.53, dollar=50 and cents = 53]
		int dollar = (int) ((difference * 100) + 0.5);//initially convert the difference into whole cent form, that is 5053 if the difference is 50.53
		int cents = dollar % 100; //take the reminder of the total cent value, dividing by 100, so the cents holds only the cent part of price
		dollar /= 100; //do the integer division of the value by 100, so that the dollar holds only the dollar part of price
		
		// create counter variables to store the number to bills to their respective variables
		int tenBills = 0, fiveBills = 0, tooniesBills = 0, looniesBills = 0, quarterBills = 0, dimeBills = 0,	nickleBills = 0;
		String change;		// initialize a string type variable named 'change' to store all the calculation of bills and will be returned 
		if (dollar == 0 && cents == 0)
		{
			change = " That will be all for today\n"; //value of dollar and cent being 0 means user has given the exact amount and doesnot get any change
		} 
		else
		{
			change = "\t";
			if (dollar >= TEN_DOLLAR)// if the change is higher than 10 dollar than calculate the number and concatenate it to change variable
			{
				tenBills = dollar / TEN_DOLLAR;
				dollar = dollar - tenBills * TEN_DOLLAR;// reduce the number of 10 dollar bills calculated___Do the process for every other dollar and cents
				change += tenBills + " $10 Bills";
			}
			if (dollar >= FIVE_DOLLAR)
			{
				fiveBills = dollar / FIVE_DOLLAR;
				dollar = dollar - fiveBills * FIVE_DOLLAR;
				change += "\n\t" + fiveBills + " $5 Bills";
			}
			if (dollar >= TWO_DOLLAR)
			{
				tooniesBills = dollar / TWO_DOLLAR;
				dollar = dollar - tooniesBills * TWO_DOLLAR;
				change += "\n\t" + tooniesBills + " Toonies";
			}
			if (dollar >= ONE_DOLLAR)
			{
				looniesBills = dollar;
				change += "\n\t" + looniesBills + " Loonies";
			}
			if (cents >= TWENTYFIVE_CENTS)
			{
				quarterBills = cents / TWENTYFIVE_CENTS;
				cents -= quarterBills * TWENTYFIVE_CENTS;
				change += "\n\t" + quarterBills + " Quarters";
			}
			if (cents >= TEN_CENTS)
			{
				dimeBills = cents / TEN_CENTS;
				cents -= dimeBills * TEN_CENTS;
				change += "\n\t" + dimeBills + " Dimes";
			}
			if (cents >= FIVE_CENTS)
			{
				nickleBills = cents / FIVE_CENTS;
				change += "\n\t" + nickleBills + " Nickels";
			}
		}
		return change;// return the final value of change which stores the required amount of change needed
	}// End of calculateChange method

	/*******************************************************************************************************************************************************
	 *                         						THE METHODS BELOW ARE NOT REQUIRED FOR THIS PROJECT                                                              *
	 *                         								THEY ARE ONLY CREATED FOR PERSONAL KNOWLEDGE                                                                 *
	 *                         																		AND                                                                                      *
	 *                         					ARE USED FOR VALIDATING/CHECKING ALL SORTS OF USER ERROR                                                           *
	 *******************************************************************************************************************************************************/
	
	
	
	/**
	 * Method Name: round()<br>
	 * Purpose: Calculate and return the rounded value to 2 decimal place<br>
	 * Accepts: Double value that needs to be rounded<br>
	 * Returns: Rounded Double value<br>
	 * Coder: Prabin Gyawali 
	 * Date: Mar 16, 2019
	 */
	public static double round(double value)
	{
		value=(value * 100)+0.5;//multiply the value by 100 and add 0.5 to round it to 2 decimal
		value= (int) value;//store only the integer part, as remaining decimals will be removed 
		return value/100;//return the value divided by 100
	}//End of method round()

	/**
	 * Method Name: isValid()<br>
	 * Purpose: Check if the given double value has just two or less decimals<br>
	 * Accepts: a double value<br>
	 * Returns: boolean value(true or false) true if the double have 2 or less decimals and false if it has more<br>
	 * Coder: Prabin Gyawali Date: Mar 16, 2019
	 */
	public static boolean isValid(double value)
	{
		Double d = value;//create a object of type Double which holds the value passed
		String[] splitter = d.toString().split("\\.");//create a string array which store the value of double which is split at '.'(dot)
		//[NOTE: As there is only one dot in the double value, the array will consist of two string variables holding the value before and after the dot]
		if (splitter[1].length() <= 2)//if the length of 2nd string, which holds the decimals is less than 2 , return true else return false
			return true;
		else
			return false;
	}//End of method isValid(double argument)

	/**
	 * Method Name: isValid()<br>
	 * Purpose: Check if the given string value is a proper double value or not<br>
	 * 					CHECKS FOR MOST OF THE HUMAN ERROR
	 * 					[Main objective is to check if the value have any spaces in between]
	 * Accepts: Overloaded to accept a String value<br>
	 * Returns: boolean value(true or false) true if the value contained in string is proper double value and false if it has more<br>
	 * Coder: Prabin Gyawali 
	 * Date: Mar 16, 2019
	 */
	public static boolean isValid(String value)
	{
		boolean test = false;//create a boolean variable which holds the value that needs to be returned
		value = value.trim();//call the trim method of string class, which removes the extra spaces from the either end of the string
		int decimalCount=0;//create variables to track count of decimal
		//Create constants to store the ASCII value of plus,minus,decimal, 0 and 9
		final int MINUS_ASCII_VALUE=45;
		final int PLUS_ASCII_VALUE=43;
		final int DECIMAL_ASCII_VALUE=46;
		final int ZERO_ASCII_VALUE=48;
		final int NINE_ASCII_VALUE=57;
		if (value.isEmpty())
			return test;//if the passed string is empty, return false
		char[] charArray = value.toCharArray();//create a char array and store the passed string as char array
		for (int i = 0; i < charArray.length; i++)//Loop until the end of array
		{
			if(i!=0 && charArray[i]==MINUS_ASCII_VALUE && charArray[i]==PLUS_ASCII_VALUE )
			{
				test = false;//if any plus or minus sign is found except at the first element, assign false to the test and break the loop
				break;
			}
			//record the number of decimal that appear in the string
			if(charArray[i]==DECIMAL_ASCII_VALUE)
				decimalCount++;
			if (charArray[i] >= ZERO_ASCII_VALUE && charArray[i] <= NINE_ASCII_VALUE)
			{
				test = true;//if the array contains number 0-9 assign test to true
			} 
			else
			{
				if(((i==0 && (charArray[0]==PLUS_ASCII_VALUE || charArray[0]==MINUS_ASCII_VALUE)) || charArray[i] == DECIMAL_ASCII_VALUE) && 
						decimalCount<=1  )
					continue;//if the array does not contain 0-9 but contains + or - as first element or contains one or less decimal continue the loop to next iteration
				test = false;//if the above condition does not satisfies assign test as false and break the loop
				break;
			}
		} // end for
		//[NOTE: WE BREAK THE LOOP EVERY TIME IF TEST IS ASSIGNED TO FALSE, 
		//				BECAUSE ONCE THE STRING DOES NOT QUALIFY AS PROPER DOUBLE VALUE AT CERTAIN POINT WE DO NOT HAVE TO CHECK THE REMAINING STRING  ]
		return test;//return the value of test
	}//End of method isValid(String argument)
}//End Class