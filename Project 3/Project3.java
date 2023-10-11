/*
* Author: Lauren Palma
* Course: COP3503
* Project #: 3
* Title: Work Order Generator
* Due Date: 7/02/2023
*
* Generates workorders from a ticket and employee CSV file.
*/

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Generates workorders from a ticket and employee CSV file. 
 */	
public class Project3 {

	public static String employeeFile = "employee_data.csv";
	public static String ticketFile = "ticket_data.csv";
	public static String workorderFile = "workorder_data.csv";
	
	public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	public static ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	public static ArrayList<Workorder> workorderList = new ArrayList<Workorder>();
	
	
	public static void main(String[] args) {
		
		System.out.println("Project 3 Work Order Generator\n");
		  
		FileHandler fileHandler = new FileHandler();
		
		System.out.println("Loading Employee Data");
		fileHandler.logger("Loading Employee Data");
		
		
		fileHandler.readEmployeeData(employeeFile);

		System.out.println("Loading Ticket Data");
		fileHandler.logger("Loading Ticket Data");

		
		fileHandler.readTicketData(ticketFile);
		
		System.out.println("Creating Work Orders");
		fileHandler.logger("Creating Work Orders");
		
	
		createWorkOrders();
		
		
		System.out.println("Writing Work Order Data to File");
		fileHandler.logger("Writing Work Order Data to File");
		
		fileHandler.writeData(workorderFile);
		
		fileHandler.logger("Work Orders Created. Program Exiting");
		System.out.println("Work Orders Created. Program Exiting");
	}
	
	/**
	 * Creates the workorders and assigns to ArrayList
	 */
	public static void createWorkOrders() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); // Date format for output
		Date date = new Date();
		double ticketsPerPerson = Math.ceil(ticketList.size() / (double) employeeList.size()); // Determines the number of tickets per person
	
		String dateTime = simpleDateFormat.format(date);
					
		int count = 0;
		int employeeNum = 0;
		
		for(int i = 1; i < ticketList.size(); i++) {
			if(count == ticketsPerPerson) { // Next employee called when true
				employeeNum++;
				count = 0;
			}
			
		dateTime = simpleDateFormat.format(date);
		Workorder workOrder = new Workorder(employeeList.get(employeeNum), ticketList.get(i), dateTime); // Creates new workorder
		workorderList.add(workOrder); // Adds new workorder to array list
		count++;
		
		}
	}


	

}
