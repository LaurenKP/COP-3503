/**
 *	Sets employee object with parameters
 */
public class Employee extends Person implements DataHandler{
	private String employeeId;
	private String clockedIn;
	private String hiredDate;

	/**
	 * Assigns parameters with information
	 * @param employeeId Employees ID
	 * @param firstName Employees first name
	 * @param lastName Employees last name
	 * @param email Employees email address
	 * @param address Employees address
	 * @param phoneNumber Employees phone number
	 * @param clockedIn Employees clocked in
	 * @param hiredDate Employees hired date
	 */
	public Employee(String employeeId,String firstName, String lastName, String email, String address, String phoneNumber,
			 String clockedIn, String hiredDate) {
		super(firstName, lastName, address, phoneNumber, email);
		
		this.employeeId = employeeId;
		this.clockedIn = clockedIn;
		this.hiredDate = hiredDate;
	}
	
	/**
	 * Gets employee id
	 * @return employee id
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * Sets employee id
	 * @param employeeID Employee id
	 */
	public void setEmployeeID(String employeeID) {
		this.employeeId = employeeID;
	}
	
	/**
	 * Sets clocked in
	 * @return clocked in
	 */
	public String getClockedIn() {
		return clockedIn;
	}
	
	/**
	 * Sets clocked in
	 * @param clockedin Employee clocked in time
	 */
	public void setClockedIn(String clockedin) {
		this.clockedIn = clockedin;
	}

	/**
	 * Gets get hired date
	 * @return hired date
	 */
	public String getHiredDate() {
		return hiredDate;
	}
	
	/**
	 * Sets hired dates
	 * @param hiredDate Employee hired date
	 */
	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
	}
	
	/**
	 * Gets specified information and outputs in format
	 */
	@Override
	public String getInfo() {
		return "Employee Info: Employee Name: " + getLastName() + "," + getFirstName() + "\t" +"Employee ID: " + getEmployeeId() + " Time Clocked In: " + getClockedIn() + "\t";
	}

	/**
	 * Gets specified information and outputs in format
	 */
	@Override
	public String getFileData() {
		return getEmployeeId() + "," + getFirstName() + "," + getLastName() + "," +getClockedIn() + ",";
	}
	
	
	
	
}
