/**
 * Program Name:	Prabin_Gyawali_INFO1214_Project.java
 * Purpose:				A simple prototype program for checkout counter which asks the user for price of items which is entered through the keyboard. 
 * 								When done, program adds the total, calculate HST and ask user for the cash.
 * 								After that , Program calculates the change and displays the change that user will get in return
 * 								Before running anything A message on the screen welcomes the user to the checkout and the program tells the user how to proceed. 
 * Coder: 				Prabin Gyawali  877282
 * Date: 					Mar 15, 2019
 * 
 * PSEUDO-CODE
 * Step 1 : create a Scanner object
 * Step 2 : Create basic  required variables
 * Step 3 : Create ArrayList to store the price that user enters
 * Step 4 : Create constants as per requirement
 * Step 5 : INPUT: Ask user to enter his/her name
 * Step 6 : Display the instruction and working mechanism to user
 * Step 7 : DO-WHILE user entered value is not equal to sentinel value
 * 						INPUT: Ask user for the price of item and store it in temporary string variable
 *	 					Validate the value by calling isValid() method
 *								if it is valid double value
 *										change the string to double and store it in temporary double variable
 *								if not valid
 *										display a message saying to enter the value again, and continue the loop 
 * 						If the validated double value is within the specified range
 * 							Store it in the array list of type Double, and increment the running total by adding the validated double value to it.
 * 						Else
 * 							Ask user to enter the value within the range
 * 						If the user input is -1, exit the loop for further calculation
 * 							If the first input is -1, display a message and quit the whole program as no further calculation is needed.
 * 					 	If the user input is 0, remove the last item stored in array list by calling method removeLastEntry() and reduce the value from running total;
 * 				 			If the first input is 0, display a message saying that there are no items to remove and continue.
 * Step 8 : PROCESSING: 
 * 						Calculate the taxAmount of the running total by calling method calculateHST()
 * 						calculate grandTotal by adding running total and taxAmount
 * 						Round the grandTotal to nearest nickel by calling method totalOwiningToNearestFive()
 * Step 9 : OUTPUT: 
 * 						print 
 * 							all the items that user entered, 
 * 							running total,
 * 							HST applied,
 * 							Grand Total,
 * 							Rounded Grand Total to nearest nickel
 * Step 10:	WHILE user does not give the proper cash
 * 						INPUT: Ask user for the amount of cash they want to pay and store it in temporary string variable
 * 						Validate the value by calling isValid() method
 *								if it is valid double value
 *										change the string to double and store it as userCash in a double variable  
 *								if not valid
 *										display a message saying to enter the value again, and continue the loop 
 *						PROCEESSING:
 *							Calculate the change that user will get 
 *							if the change is less than 0
 *									Display a message that amount is not sufficient 
 *							else
 *									make the loop flag true indicating that we have received proper cash
 * Step 11:	OUTPUT:
 *					Display the cash provided by user and change amount
 *					Display the total bills that user will get by calling the method calculateChange()
 *					
 * Step 12: HOUSEKEEPING: close the Scanner object
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Prabin_Gyawali_INFO1214_Project
{
	public static void main(String[] args)
	{
		// Create a Scanner object
		Scanner input = new Scanner(System.in);
		
		// Create basic  required variables
		String userName = new String();// String Variable to hold the username of the user
		double runningTotalPrice = 0;// double variable to store the total price of the purchase
		double taxAmount = 0; // variable to store the tax amount applied to the purchase
		double grandTotal = 0; // variable to store grand total which is addition of total and tax amount
		double roundGrandTotal = 0; // variable to store the store the grand total which is rounded to nearest nickel
		double userCash = 0; // variable to store the cash that user pays for the items
		double change = 0; // variable to store the change that the store needs to provide back to the user
		double tempStorage=0; // variable to temporarily store the price entered by the user for validation purpose
		int items = 1; // Variable to store the total number of items, Initialize it to 1 so that the program ask about the price for item #1
		String userInputPrice; // String variable to store the user input price for validation purpose
		
		ArrayList<Double> price = new ArrayList<Double>();// an Array list to store all the price that user enters

		// Create constant to specify the range of the price of the items that user can enter
		final double MAX_PRICE_VALUE = 179.99;
		final double MIN_PRICE_VALUE = 0;

		final int SENTINEL_VALUE = -1;
		// Design of the program header
		System.out.println("\t\t\t+-------------------------------------------+");
		System.out.println("\t\t\t|\tiDea! Checkout System Ver. 1.0      |");
		System.out.println("\t\t\t+-------------------------------------------+");

		// Prompt the user to enter his/her name and store it
		System.out.print("Hi. Welcome to the iDea! store. What is your name? ");
		userName = input.nextLine();

		// Display the instruction to the user about the working mechanism of the program
		System.out.println("Ok, " + userName + ", enter the price of each purchase in dollars and cents and hit the ENTER key.");
		System.out.println("For example, if your item costs $5.99, you would enter 5.99\n");
		System.out.println("If you make a mistake when you enter a price enter a zero for the next entry.");
		System.out.println("The last price you entered will be subtracted from your sub-total.\n");
		System.out.println("When you've entered all of your prices, enter "+SENTINEL_VALUE+" to indicate that you are done.");
		System.out.println("I’ll then calculate what your total owing is.\n\nLet's begin!\n");
		
		do
		{
			// Prompt user to enter the price of items and store any value that user enters as string
			System.out.print("\nEnter a price for item #" + items + ": $");
			userInputPrice = input.nextLine();

			// Call the isValid method to check , if the entered value is valid double value
			if (Methods.isValid(userInputPrice))
			{
				tempStorage = Double.parseDouble(userInputPrice);// convert the stored string value to double value and store, if its valid
			}
			// If the user enters any other value than double, display the message to indicate it as an invalid price
			else
			{
				System.out.println("INVALID PRICE: please re-enter…");
				continue;// if the price is invalid go to the start of the loop
			}
			// Check if the entered value is the sentinel value
			if (tempStorage == SENTINEL_VALUE)
			{
				if (items != 1) // If value of item is more than 1 than display a message that we are exiting the loop
				{
					System.out.println("-1 entered, calculating total owing…\n");
				} 
				else // Else user enters -1 without entering any item, Display a message and exit the program, 
							//so that the program does not have to calculate anything further.
				{
					System.out.println("\nQuiting the system without any Items!");
					System.out.println("See you again, " + userName + "!");
					System.exit(0);
				}
			} // End IF
			else if (tempStorage == 0)// Integer value of 0 is to delete the last entered item in the price array list
			{
				if (items == 1)// If the user enter 0 at the first item, display a message that there are no items
				{
					System.out.println("Error occurred! No items to remove.");
				} 
				else// If there is one or more items in the list delete the last item
				{
					// First deduce the price of last item from the total price
					runningTotalPrice -= price.get(price.size() - 1);
					// Display a message that we are removing last item and call the method removeLastEntry() from self made methods class
					System.out.printf("Zero entered: removing last item $%.2f…your sub-total is now $%.2f\n",price.get(price.size() - 1), runningTotalPrice);
					Methods.removeLastEntry(price);
					// decrease the number of items by 1
					items--;
				}
			} // End else if
			// If the price falls under the range and is a valid price do the required calculation
			else if (tempStorage > MIN_PRICE_VALUE && tempStorage <= MAX_PRICE_VALUE && Methods.isValid(tempStorage))
			{
				// Add the temporarily stored price to the price list
				price.add(tempStorage);
				// Add the value of temporarily stored price to the total
				runningTotalPrice = runningTotalPrice + tempStorage;
				// Increase the count of items by 1
				items++;
				System.out.printf("That was $%.2f. Your sub-total is $%.2f\n", tempStorage, runningTotalPrice);
			} // End Else if

			// If the user input is Double but does not satisfies any of the condition, display the message that
			// The user entered price is either out of range or is invalid
			else
			{
				if(Methods.isValid(tempStorage))
					System.out.println("PRICE OUT OF RANGE: please re-enter");
				else
					System.out.println("PRICE CONTAINS MORE THAN 2 DECIMAL NUMBER: please re-enter…");
			}
		} while (tempStorage!=SENTINEL_VALUE);// End While

		// CALCULATION:
		// Calculate the tax by calling the method calculateHST() from the self defined class Methods
		taxAmount = Methods.calculateHST(runningTotalPrice);
		grandTotal = runningTotalPrice + taxAmount;// add the total price and tax and store as grand total
		// round the obtained grand total to nearest nickel by calling the method totalOwiningToNearestFive() from the self defined class Methods
		roundGrandTotal = Methods.totalOwiningToNearestFive(runningTotalPrice, taxAmount);

		// Use a for loop to Display all the prices from the Array list of name price
		System.out.println("OK " + userName + ", your individual purchase prices are:");
		for (int i = 0; i < price.size(); i++)
		{
			System.out.printf("$%.2f\n", price.get(i));
		}

		// Display the total price, tax amount grand total
		System.out.printf("YOUR SUB-TOTAL IS: $%.2f\n", runningTotalPrice);
		System.out.printf("\nThe HST Sales Tax on your purchases is: $%.2f\n", taxAmount);
		System.out.printf("\nYOUR GRAND TOTAL IS: $%.2f, which will round to $%.2f.\n\n", grandTotal, roundGrandTotal);

		boolean validate = false;// loop flag to check the input of users
		// Run the loop until the value of validate is true
		while (!validate)
		{
			// Ask the user to enter the cash for the payment
			System.out.print("Enter the amount of cash you are tendering for payment: $");

			userInputPrice = input.nextLine();
			// Call the isValid method to check , if the entered value is valid double value
			if (Methods.isValid(userInputPrice))
			{
				userCash = Double.parseDouble(userInputPrice);// convert the stored string value to double value and store, if its valid
			}
			// If the user enters any other value than double, display the message to indicate it as an invalid price
			else
			{
				System.out.println("INVALID AMOUNT ENTERED: please re-enter … \n");
				continue;// if the price is invalid go to the start of the loop
			}
			// calculate the change amount and store it.
			change = Methods.round(userCash - roundGrandTotal);
			// NOTE: IF THE VALUE OF CHANGE IS GREATER OR EQUAL TO 20, THAN THE PROGRAM UNDERSTAND THAT THE USER IS PROVIDING THE 50 OR 100 DOLLAR BILLS.
			// OUR STORE ONLY ACCEPTS 20 DOLLAR BILLS SO THE CHANGE MUST ALWAYS BE LESS THAN 20 DOLLAR
			if (change < 20)
			{
				// CHECK IF THE USER ENTERED CASH IS REALISTICALLY VALID(DOESNOT CONTAIN PENNIES), AND CHANGE IS GREATER THAN ZERO
				// If yes than assign validate to true to indicate that the input is valid and exit the loop else display the error message as required
				if ((int) (Methods.round(userCash * 100)) % 5 == 0 && Methods.isValid(userCash) && !(change < 0))
				{
					validate = true;
				} 
				else
				{
					if (change < 0)
						System.out.println("INSUFFICIENT AMOUNT: please re-enter ... \n");
					else
						System.out.println("MINIMUM CASH WE TAKE IS NICKEL, WE DONT TAKE PENNIES : please re-enter … \n");
				}
			} // END IF(change<20)
			else
			{
				System.out.println("Sorry we don't take $100 or $50 bills\n");
			}
		} // End While
		// FINAL OUTPUT
		// Display the final output by calling appropriate methods as required
		System.out.printf("From $%.2f  your change is $%.2f\n", userCash, change);
		System.out.println(Methods.calculateChange(roundGrandTotal, userCash));
		System.out.println("Please check that your change received is correct.\n");
		System.out.println("Thanks for shopping at iDea, " + userName + "!");

		// Housekeeping
		// Close the scanner object
		input.close();
	}// End Main
}// End Class