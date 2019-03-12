/**
 * Program Name:	Calander.java
 * Purpose:				Display the calendar for certain month by asking the year and month from user
 * Coder: 				Prabin Gyawali
 * Date: 					Mar 11, 2019
 * Copyright © PrabinGyawali
*/

import java.util.Scanner;
public class Calander
{

	public static void main(String[] args)
	{
		// Create the scanner object
		Scanner input=new Scanner(System.in);
				
		//Create an Array to store all 12 month. Leave the first element empty so that, January is stored in Month[1]
		String[] month= {"","January", "February", "March","April", "May", "June","July", "August", "September","October", "November", "December"};
		
		//Create an integer array to store days in month
		int[] daysInMonth= {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int yearInput=0;
		int monthInput=0;
		
		boolean isLeapYear;
		//Create an boolean flag variable
		boolean isInt=false;
		
		while(!isInt)
		{
			//Prompt user to enter the Year and Month and store it
			System.out.print("Enter the year, you want to see calender(1700-2019): ");
			/** Copyright © PrabinGyawali**/
			if(input.hasNextInt())
			{
				yearInput=input.nextInt();
				if(yearInput>=1700 && yearInput<=2400) 
				{
					 isInt=true;
				}
				else
				{
					System.out.println("Enter within range. Please try again\n ");/** Copyright © PrabinGyawali**/
				}
			}
			else
			{
				System.out.println("Input invalid Please try again\n ");
			}
			input.nextLine();
		}
		
		isInt=false;
		while(!isInt)
		{
			//Prompt user to enter the Year and Month and store it
			System.out.print("Enter the moth as number(1-12): ");
			if(input.hasNextInt())
			{
				monthInput=input.nextInt();
				/** Copyright © PrabinGyawali**/
				if(monthInput>=1 && monthInput<=12) 
				{
					 isInt=true;
				}
				else
				{
					System.out.println("Enter within range. Please try again\n ");
				}
			}/** Copyright © PrabinGyawali**/
			else
			{
				System.out.println("Input invalid Please try again\n ");
			}
			input.nextLine();
		}
		
		
		//check for leap year
		if  (((yearInput % 4 == 0) && (yearInput % 100 != 0))||(yearInput % 400 == 0))
		{
			isLeapYear=true;
		}
		else/** Copyright © PrabinGyawali**/
		{
			isLeapYear=false;			
		}
		
		//Change the number of days if year is leap year and month is February
		if(monthInput==2 && isLeapYear)
			daysInMonth[2]=29;
		/** Copyright © PrabinGyawali**/
		//formula to calculate the start of first day of month in week
		final int DAY=1;
		int firstDay=0;
		int century=yearInput/100;
		int yearCalculation,monthCalculation;
		if(monthInput==1||monthInput==2)
		{
			yearCalculation=yearInput%100-1;
			monthCalculation=monthInput+10;
		}
		/** Copyright © PrabinGyawali**/
		else 
		{
			yearCalculation=yearInput%100;
			monthCalculation=monthInput-2;
			
		}
		
		/* Calculate the first day of month, Formula referenced from
		https://cs.uwaterloo.ca/~alopez-o/math-faq/node73.html **/
		firstDay=(DAY+(int)(2.6*monthCalculation-0.2)-2*century+yearCalculation+yearCalculation/4+century/4)%7;
		if(firstDay<0)
			firstDay=firstDay+7;
		/** Copyright © PrabinGyawali**/
		//Print the Format of Calendar
		System.out.println("\n\t\t\tCalendar for Month");
		System.out.println("  \t\t\t   "+month[monthInput]+", "+yearInput);
		System.out.println("\n\tSun\tMon\tTue\tWed\tThu\tFri\tSat");
		System.out.print("\t");
		for(int i=0;i<firstDay;i++)/** Copyright © PrabinGyawali**/
			System.out.print("\t");
		for(int i=1;i<=daysInMonth[monthInput];i++)
		{
			System.out.print(i+"\t");/** Copyright © PrabinGyawali**/
			if((i+firstDay)%7==0)
			{	
				System.out.println("");
				System.out.print("\t");/** Copyright © PrabinGyawali**/
			}
		}
		
		input.close();/** Copyright © PrabinGyawali**/
	}
	//End Main
}
//End Class
/** Copyright © PrabinGyawali**/