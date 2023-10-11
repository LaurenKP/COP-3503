/* 
 *  Author: Lauren Palma
 *  Course: COP3503 
 *  Project #: 1 
 *  Title  : Display Menu
 *  Due Date: 06/10/2023
 *  
 *  Takes user input to display a menu that outputs different values based on user choice.
 */ 
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Arrays;

/** 
 * Manipulates user input to output different values
 */ 
public class project1 {
	public static void main(String[] args)
	{
		displayMenu();
	}
	/** 
	 * Takes user input based on menu choices. 
	 * Different info displayed is based on user input. 
	 * @param input takes user input to display different information. 
	 * @param checker boolean value is used to keep menu iterating while true
	 */ 
	public static void displayMenu()
	{
		Scanner scnr = new Scanner(System.in);//scanner
		String [] list = readIn(scnr);//reads users words
		boolean checker = true;//value used to keep iterating 

		do
		{
			System.out.println("Please enter a choice");
			System.out.println("1) Display List Ordered");
			System.out.println("2) Display Word Length");
			System.out.println("3) Display List Statistics");
			System.out.println("4) Number of Odd/Even Words");
			System.out.println("5) Check for Prime Length");
			System.out.println("6) Enter New Word List");
			System.out.println("7) Quit Program");

			// Get user input 
			String input = scnr.nextLine();

			switch(input)
			{
			case "1":
				listOrdered(list);
				break;
			case "2":
				listLength(list);
				break;
			case "3":
				int n = list.length;
				minLength(list);
				maxLength(list);
				numChars(list);
				nounCheck(list);
				avgLength(list);
				freq(list, n);
				break;
			case "4":
				evenOdd(list);
				break;
			case "5":
				primeWords(list);
				break;
			case "6":
				list = readIn(scnr);
				break;
			case "7":
				System.out.println("Program Exiting");
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Selection!");
			}//end of switch

		}//end of do 
		while(checker);
		scnr.close();	
	} //end of menu
	/** 
	 * Reads in sentence to use with different methods.
	 * @param list, The sentence put in by user. 
	 * @return sentence to be used in DisplayMenu method. 
	 */ 
	
	public static String[] readIn(Scanner scnr) 
	{
		// Gets user input 
		System.out.println("Enter a list of words seperated by spaces");//prompts user to enter input
		scnr = new Scanner(System.in); //reads in input 
		String [] list  = scnr.nextLine().split(" ");//scanning the string based on the separator passed
		return list;//displays list 

	}
	/** 
	 * Sorts the words in an array. 
	 * @param list, the sentence put in by the user. 
	 * @return List of the array in order. 
	 */ 
	public static String [] listOrdered(String [] list) 
	{
		Arrays.sort(list);//sorts it in place
		System.out.println(Arrays.toString(list));//displays
		return list;
	}//end of listOrdered
	/** 
	 * Counts number of even and odd words in array list 
	 * @param even counter used to output number of even words as loop iterates. 
	 */ 
	public static void evenOdd(String [] list)
	{
		//variable declaration
		int even = 0; //count int to compare 
		
		for(int i = 0; i < list.length;  i++)
		{
			if(list[i].length() %2  == 0)//if used to divides by 2 
				even++;
		}//end for loop
		System.out.println("Number even: " + even);//displays even 
		System.out.println("Number odd: " + (list.length - even));//displays odd by subtracting even from list 
	}//end of evenOdd
	/** 
	 * Displays length of each word in array. 
	 * @param list The sentence put in by user.  
	 */ 
	public static void listLength(String [] list)
	{
		for(int i = 0; i< list.length; i++)
		{
			System.out.println(list[i] + " Length is " + list[i].length());//displays list
		}//end of for used to count and display
	}//end of listLength
	/** 
	 * Calculates average length of all words in array. 
	 * @param count used to count length of each word.
	 * @param sum sum of all the words length
	 * @param average used to calculate average word length using sum and count
	 * @param DecimalFormat used to format the calculate average to 2 decimal points
	 */ 
	public static void avgLength(String [] list)
	{
		//variable declaration
		final DecimalFormat test = new DecimalFormat("0.00");
		int count = 0;
		double sum = 0;
		
		for(int i = 0; i < list.length; i++)
		{
			double wordLength = list[i].length();
			sum+= wordLength;
			count++;
		}//end for that counts and stores length 
		double average = 0;
		
		if(count >0)
		{
			average = sum/count;//math
		}//end of if
		//Display average word length of list to user
		System.out.println("Average word length: " + test.format(average));
	}//end of avgLength method
	/** 
	 *Displays number of characters in array 
	 * @param count used to count length of each word.
	 * @param sum sum of all the words length
	 * @param average used to calculate average word length using sum and count
	 */ 
	public static void numChars(String [] list)
	{
		//variable declaration
		int count =0;
		
		for(int i = 0; i < list.length; i++)
		{
			char [] letterArray = list[i].toCharArray();//converts string into a sequence of characters. 
														 
			for(int j = 0; j < letterArray.length; j++)//(for) used to count characters
			{
				if(Character.isLetter(letterArray[j]));//if isLetter then counted 
				count++;//to store value from (for)
			}//end of embedded for
		}//end of for
		
		System.out.println("Total Number of characters: " + count);//Display total number of characters in list to user
	}//end of numChars method 
	/** 
	 *Displays most frequent word
	 * @param freq used hold frequency of most frequent word
	 * @param space used to hold most frequent string
	 */ 
	public static void freq(String [] list, int n)
	{
		//variable declaration
		int freq =0;
		String space = "";
		
		for (int i = 0; i < n; i++)
		{
			int count = 0;//stores count
			for (int j = i + 1; j < n; j++)
			{
				if (list[j].equalsIgnoreCase(list[i]))
				{
					count++;
				}//end of if that counts
			}//end of for that compares variables
			if(count >= freq)
			{
				freq = count;
				space = list[i];
			}//end of if
		}//end of for 
		
		System.out.println("Most Frequent Word: " + space);//Display most occurring word to user
	}//end of freq method
	/** 
	 *Calculates and displays length of longest word
	 * @param longest used to hold the longest word
	 */ 
	public static void maxLength(String [] list)
	{
		//variable declaration
		int longest = 0;
		
		for(int i = 0; i < list.length; i++)
		{
			if(list[i].length() > longest )
			{
				longest = list[i].length(); //compares to longest word
			}//end of if
		}//end of for 
		
		System.out.println("Max Word Length: " + longest);//Display length of longest word to user
	}//end of maxLength method
	/** 
	 *Calculates and displays length of shortest word
	 * @param shortest used to hold the shortest word
	 */ 
	public static void minLength(String [] list)
	{
		//variable declaration
		int shortest = 0;
		
		shortest = list[0].length();
		for(int i = 0; i < list.length; i++)
		{
			if(list[i].length() < shortest)
			{
				shortest = list[i].length();
			}//end of if
		}//end of for
		//Display length of shortest word to user
		System.out.println("Min Word Length: " + shortest);
	}//end of minLength
	/** 
	 *Checks for nouns in list
	 * @param upper used to hold the number of uppercase words
	 */ 
	public static void nounCheck(String [] list)
	{
		//variable declaration
		int upper = 0;
		
		for(int i = 0; i < list.length; i++)
		{
			char letterArray = list[i].charAt(0); 
			boolean check = Character.isUpperCase(letterArray);// checks if true uppercase
			if(check)
			{
				upper++;//counter stores
			}//end of if
		}//end of for
		//Display number of nouns to user
		System.out.println("Number of Nouns: " + upper);
	}//end of nownChecker
	/** 
	 *Calculates if value is prime or not
	 */ 
	public static boolean isPrime(int n)
	{
		if(n < 2)
		{
			return false;
		}//end of if, compares to prime 2
		for(int i = 2; i < Math.sqrt(n); i++)
		{
			if(n % i == 0)
			{
				return false;
			}//end of if that returns false if not prime
		}//end of for
		return true;
	}//end of isPrime checker
	/** 
	 *Displays number of words with prime lengths
	 *@param prime used to hold the number of words with prime lengths
	 */ 
	public static void primeWords(String [] list)
	{
		//variable declaration
		int prime = 0;//used to store number of prime words
		
		for(int i = 0; i< list.length; i++)
		{
			if(isPrime(list[i].length()))
			{
				prime++;
			}//end of if that compares and stores in count
		}//end of for 
		//Display number of prime length words to user
		System.out.println("Number of Prime in list: " + prime);
	}//end of primeWord method
}//end of class
