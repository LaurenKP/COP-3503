/*
* Author: Lauren Palma
* Course: COP3503
* Project #: 2
* Title : Data Processing
* Due Date: 06/21/2023
*
* 
*/


import java.io.*;
import java.text.*;
import java.util.*;


public class Project2 {
	
	public static ArrayList<String> dates = new ArrayList<String>();
	public static ArrayList<String> times = new ArrayList<String>();
	public static ArrayList<Double> sensor2278 = new ArrayList<Double>();
	public static ArrayList<Double> sensor3276 = new ArrayList<Double>();
	public static ArrayList<Double> sensor4689 = new ArrayList<Double>();
	public static ArrayList<Double> sensor5032 = new ArrayList<Double>();
	public static ArrayList<Double> section1Diff = new ArrayList<Double>();
	public static ArrayList<Double> section2Diff = new ArrayList<Double>();
	public static ArrayList<Double> totalAvg = new ArrayList<Double>();


	public static void main(String[] args) 
	{
		
		boolean fileNameCorrect = false;
		String fileName = "";
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Project 2 Data Preprocessing\n");
		System.out.println("Enter file name & location.");
		while(!fileNameCorrect) 
		{
		
		try 
		{
			fileName = scnr.nextLine();
			FileReader fileReader = new FileReader(fileName); //Check if file is correct
			System.out.println("Reading in Data from the file " + fileName);
			
			//Reads in from files
			dates = readInString(0,fileName); //index starts at 1
			times = readInString(1,fileName); //index starts at 1
			sensor2278 = toDoubleArray(readInString(2, fileName)); //index starts at 0
			sensor3276 = toDoubleArray(readInString(3, fileName)); //index starts at 0
			sensor4689 = toDoubleArray(readInString(4, fileName)); //index starts at 0
			sensor5032 = toDoubleArray(readInString(5, fileName)); //index starts at 0
			
			formatDate(dates); //Dates in new format
			System.out.println("Converting Dates from MM/DD/YYYY to YYYY/MM/DD");
			
			//Calc difference 
			section1Diff = findDifference(sensor2278, sensor3276);
			section2Diff = findDifference(sensor4689, sensor5032);
			System.out.println("Calculating Speed Difference");
			
			//Calc average
			totalAvg = findSpeedAverage(sensor2278, sensor3276, sensor4689, sensor5032);
			System.out.println("Calculating Speed Average");
			
			//Writing to file
			String newFileName = fileName.replace(".csv", "_difference.csv");
			writeToNewFile(newFileName);
			System.out.println("Writing data to file " + newFileName);
			
			fileNameCorrect = true;
			System.out.println("Done! Exiting Program");
			
			try 
			{
				fileReader.close();
			}//end of inner try 
			catch (IOException e) 
				{
				//TODO Auto-generated catch block
				e.printStackTrace();
				}//end of catch
			
		}//end of try
		catch (FileNotFoundException e) 
			{ // Bad input example 2 done
			//TODO Auto-generated catch block
			System.out.println("Reading in Data from the file "+fileName);
			System.out.println("*File does not exist or path was entered incorrectly.*");
			System.out.println("Please try again.");
			System.out.println("Enter file name & location.");
			clearList();
			
			}//end of catch 1
		catch (NumberFormatException e) 
			{ 
			// Bad input example 1 done
			// TODO Auto-generated catch block
			System.out.println("*Bad Number Data in CSV File.*");
			System.out.println("Check CSV file data and try again.");
			System.out.println("Enter file name & location.");
			clearList();
			
			}//end of catch 2
		catch (ParseException e) 
			{ 
			// Bad input example 3
			// TODO Auto-generated catch block
			System.out.println("*Bad Date Data in CSV File.*");
			System.out.println("Check CSV file data and try again.");
			System.out.println("Enter file name & location.");
			clearList();
			}//end of catch 3
		
			}
		scnr.close();//closing 
	}//end of main 
	/**
	 * This takes in original CSV File and assigns column to respected array list.
	 * @param column Determines which column will be accessed.
	 * @param filePath Determines file location.
	 * @return The column in ArrayList form.
	 */
	public static ArrayList<String> readInString(int column, String filePath) 
	{
		 ArrayList<String> columnInfo = new ArrayList<String>();
		 String currentLine;
		 String stringData[];
		 
		 try 
		 {
			 FileReader fileReader = new FileReader(filePath);
			 BufferedReader bufferReader = new BufferedReader(fileReader);
			 
			 while((currentLine = bufferReader.readLine()) != null) 
			 {
				 stringData = currentLine.split(",");
				 columnInfo.add(stringData[column]); // Gets data from specified column and adds to ArrayList
			 }//end of while
			 bufferReader.close();
		 }//end of try 
		 catch(Exception e) 
		 {
			 System.out.println("Failed during readInString()\n");
			 System.out.println(e);
		 }//end of catch
		
		 
		return columnInfo;
	}//end of ArrayList method 
	
	/** This converts ArrayList from String to Double
	 * @param input String ArrayList
	 * @return ArrayList in Double form.
	 */
	public static ArrayList<Double> toDoubleArray(ArrayList<String> input) 
	{
		
		ArrayList<Double> stringList = new ArrayList<Double>();
		
			for(int i = 1; i < input.size(); i++) 
				{
			        stringList.add (Double.parseDouble(input.get(i)));
			    }//end of for
		
	
		return stringList;
		 
	}//end of method
	
	/**
	 * Finds the difference between two columns.
	 * @param row1 ArrayList 1 base.
	 * @param row2 ArrayList 2 subtraction value.
	 * @return Difference between the two values.
	 */
	public static ArrayList<Double> findDifference(ArrayList<Double> row1, ArrayList<Double> row2) 
	{
		ArrayList<Double> difference = new ArrayList<Double>();
		
		for (int i = 0; i < row1.size(); i++) 
		{
			double temp = row1.get(i)-row2.get(i);
			difference.add(temp);
		}//end of for
		return difference;
	}//end of findDifference 
	
	/**
	 * findSpeedAverage finds average speed between the four columns in the same row.
	 * @param row1 First sensor.
	 * @param row2 Second sensor.
	 * @param row3 Third sensor.
	 * @param row4 Fourth Sensor.
	 * @return speed average for that row.
	 */
	public static ArrayList<Double> findSpeedAverage(ArrayList<Double> row1, ArrayList<Double> row2, ArrayList<Double> row3, ArrayList<Double> row4) 
	{
		
		ArrayList<Double> averageSpeed = new ArrayList<Double>();
		double sum;
		for(int i = 0; i < row1.size(); i++) 
		{
			sum = row1.get(i);
			sum += row2.get(i);
			sum += row3.get(i);
			sum += row4.get(i);
			
			averageSpeed.add(sum / 4.0);
		}//end of for
		return averageSpeed;
	}//end of findSpeedAverage method

	/**
	 * Writes the formatted ArrayList data to a CSV file.
	 * @param newFileName Used to write to the new file location
	 */
	public static void writeToNewFile(String newFileName)
	{
		
		FileWriter fileWriter;
		try 
		{
			fileWriter = new FileWriter(newFileName);
			PrintWriter printWriter = new PrintWriter(fileWriter);
		    StringBuffer header = new StringBuffer("");
		    StringBuffer data = new StringBuffer("");
		    
		    header.append("Date, Time, Sensor_2278, Sensor_3276, Sensor_4689, Sensor_5032, Section1_Diff, Section2_Diff, Total_Avg\n");
		    
		    // Write header
		    printWriter.write(header.toString());
		    
		    for(int i = 0; i < dates.size()-1; i++)
		    {
		    	data.append(dates.get(i+1)); // Array starts at 1
		    	data.append(',');
		    	data.append(times.get(i+1)); // Array starts at 1
		    	data.append(',');
		    	data.append(sensor2278.get(i));
		    	data.append(',');
		    	data.append(sensor3276.get(i));
		    	data.append(',');
		    	data.append(sensor4689.get(i));
		    	data.append(',');
		    	data.append(sensor5032.get(i));
		    	data.append(',');
		    	data.append(section1Diff.get(i));
		    	data.append(',');
		    	data.append(section2Diff.get(i));
		    	data.append(',');
		    	data.append(totalAvg.get(i));
		    	data.append('\n');
		    	
		    }//end of for
		    
		    printWriter.write(data.toString()); // Writes all data to CSV file
		    printWriter.close();
		    fileWriter.close();
		    
		    
		}//end of try
		catch (IOException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}//end of catch
	}//end of writeToNewFile
	
	/**
	 * Changes the dates from MM/DD/YY to YYYY/MM/DD.
	 * @param dates The ArrayList full of dates.
	 * @throws ParseException Throws error if parsing fails.
	 */
	public static void formatDate(ArrayList<String> dates) throws ParseException 
	{
		//Format the date to year/month/day
		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		
		for(int i = 1; i < dates.size(); i++)
		{
		 date = sdf.parse(dates.get(i)); // Original format set
	     DateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
	     dates.set(i, formatDate.format(date)); // New format parsed
		
		}//end of for
	}//end of formatDate method
	
	/**
	 * This method clears the ArrayLists current values.
	 * clearArrayList is called when an exception occurs.
	 */
		public static void clearList() 
		{
			dates.clear();
			times.clear();
			sensor2278.clear();
			sensor3276.clear();
			sensor4689.clear();
			sensor5032.clear();
			section1Diff.clear();
			section2Diff.clear();
			totalAvg.clear();
		}//end of clearList method
	
}//end of class
