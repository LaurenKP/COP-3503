import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Handles input and output
 */

public class FileHandler {	
	/**
	 * Reads in employee data and assigns to array list
	 * @param employeeFile The file location
	 */
	public  void readEmployeeData(String employeeFile) {
		String currentLine = "";
		
		
	try{
		FileReader fileReader = new FileReader(employeeFile);
		BufferedReader bufferReader = new BufferedReader(fileReader);
		bufferReader.readLine(); // Skips first line

		while((currentLine = bufferReader.readLine()) != null) {
			currentLine.split(",");
			String[] data = currentLine.split(","); // Splits data and gets put into array
			Employee employee = new Employee(data[0], data[1], data[2], data[3], data[4], data[5], data[6],data[7]); 
			Project3.employeeList.add(employee);
		}
		
		bufferReader.close();
		fileReader.close();
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	/**
	 * Reads in data and to array list
	 * @param ticketFile The file location
	 */
	public void readTicketData(String ticketFile) {
		String currentLine = "";		
		
		try{
		FileReader fileReader = new FileReader(ticketFile);
		BufferedReader bufferReader = new BufferedReader(fileReader);
		
		
		while((currentLine = bufferReader.readLine()) != null) {
			currentLine.split(",");
		
			String[] data = currentLine.split(","); // Delimiter to split CSV file
			Customer customer = new Customer(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
			
			Ticket ticket = new Ticket(customer, data[7], data[8]);
			Project3.ticketList.add(ticket);
		}
		
		bufferReader.close();
		fileReader.close();
		}
		
		
		catch(Exception e) {
			System.out.println(e);
		}
	
	}
	
	/**
	 * Writes data to workorder file
	 * @param workOrderFileName File location
	 */
	public void writeData(String workOrderFileName) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(workOrderFileName);
			PrintWriter printWriter = new PrintWriter(fileWriter);
		    StringBuffer header = new StringBuffer("");
		    StringBuffer data = new StringBuffer("");
		    
		    header.append("employee_id,employee_first_name,employee_last_name,clocked_in,customer_id,customer_first_name,"
		    		+ "customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt");
		    
		    // Write header
		    printWriter.write(header.toString());
		    data.append("\n");
		    for(int i = 0; i < Project3.workorderList.size(); i++) {
		    	data.append(Project3.workorderList.get(i).getFileData()); 
		    	data.append('\n');
		    }
		    
		    printWriter.write(data.toString()); // Writes all data to CSV file
		    printWriter.close();
		    fileWriter.close();
		    
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes workorder data to log file
	 * @param logMessage Log message to be appended
	 */
	public void logger(String logMessage) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); // Sets date format
		Date date = new Date();
		
		String dateTime = simpleDateFormat.format(date);
		
		try {
			FileWriter fileWriter = new FileWriter("log.txt", true);
			fileWriter.write(dateTime + " " + logMessage + "\n"); // Writes log message to .TXT file
			
			if(logMessage.equals("Writing Work Order Data to File")){ // Writes logging of workorder to file when true
				for(int i = 0; i < Project3.workorderList.size(); i++) {
					fileWriter.write(dateTime + ": ");
					fileWriter.write(Project3.workorderList.get(i).getInfo()); 
					fileWriter.write('\n');
				}
			}
			fileWriter.close(); 
			}
	
		catch (Exception e) {
			System.out.println();
		}
	}
}
