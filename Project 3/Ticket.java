/**
 * Sets ticket object with parameters
 */

public class Ticket implements DataHandler {
	private String createdAt;
	private String ticketId;
	
	Customer customer;
	 /**
	  * Assigns parameters with information
	  * @param customer Customer object
	  * @param ticketId Ticket id
	  * @param createdAt Ticket created at
	  */
	Ticket(Customer customer, String ticketId, String createdAt){
		this.createdAt = createdAt;
		this.ticketId = ticketId;
		this.customer = customer;
	}
	
	/**
	 * Gets created at time
	 * @return created at
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets created at
	 * @param createdAt Time it was created
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets ticket id
	 * @return ticket id
	 */
	public String getTicketId() {
		return ticketId;
	}

	/**
	 * Sets ticket id
	 * @param ticketId Id of ticket
	 */
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * Get customer object
	 * @return customer object
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets customer  object
	 * @param customer Customer object
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Gets specified information and outputs in format
	 */
	@Override
	public String getInfo() {
		return customer.getInfo() + " Created At: " + getCreatedAt() + " Ticket Id: " + getTicketId();
	}

	/**
	 * Gets specified information and outputs in format
	 */
	@Override
	public String getFileData() {
		return customer.getFileData() + "," + getTicketId() + "," + getCreatedAt();
	}
}
