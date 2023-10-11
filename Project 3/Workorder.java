/**
 * Sets ticket object with parameters
 */

public class Workorder implements DataHandler{
	private String createdAt;
	Employee employee;
	Ticket ticket;

	/**
	 * Assigns parameters with information
	 * @param employee Workorder employee object
	 * @param ticket Workorder ticket object
	 * @param createdAt Workorder created at
	 */
	public Workorder(Employee employee, Ticket ticket, String createdAt) {
		this.employee = employee;
		this.ticket = ticket;
		this.createdAt = createdAt;
	}

	/**
	 * Gets created at
	 * @return created at time
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets created at
	 * @param createdAt Workorder created at
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets employee object
	 * @return employee object
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * Sets employee object
	 * @param employee Employee object
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * Gets ticket object
	 * @return ticket object
	 */
	public Ticket getTicket() {
		return ticket;
	}
	
	/**
	 * Sets ticket object
	 * @param ticket Ticket object
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/**
	 * Gets specified information and outputs in format
	 */
	@Override
	public String getInfo() {
		return employee.getInfo() + " " +  ticket.getInfo() + " Workorder Info:\tCreated At: " + getCreatedAt();
				
	}

	/**
	 * Gets specified information and outputs in format
	 */
	@Override
	public String getFileData() {
		return employee.getFileData() + ticket.getFileData() + "," + getCreatedAt();
	}
}
