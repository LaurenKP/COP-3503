/**
 *	Sets customer object with parameters
 */
public class Customer extends Person implements DataHandler{
	private String customerId;
	private String accountNumber;
	
	/**
	 * Assigns parameters with information
	 * @param customerId Customers id
	 * @param firstName Customers first name
	 * @param lastName Customers last name
	 * @param email Customers email
	 * @param address Customers address
	 * @param phoneNumber Customers phone number
	 * @param accountNumber Customers account number
	 */
	
	public Customer(String customerId, String firstName, String lastName, String email, String address, 
			String phoneNumber, String accountNumber) {
		super(firstName, lastName, address, phoneNumber, email);
		
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		
	}
	
	/**
	 * Gets customer id
	 * @return customer id
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Sets customer id 
	 * @param customerId Customer id
	 */
	public void setCustomerID(String customerId) {
		this.customerId = customerId;
	} 

	/**
	 * Gets account number
	 * @return Customers account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Sets account number
	 * @param accountNumber Customers account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Gets specified information and outputs in format
	 */
	@Override
	public String getInfo() {
		return "Customer Info: Customer Name: " + getLastName() + "," + getFirstName() + " Customer ID: " + getCustomerId() + " Account Number: "
				+ getAccountNumber();
	}

	/**
	 * Gets specified information and outputs in format
	 */
	@Override
	public String getFileData() {
		return getCustomerId() + "," + getFirstName() + "," + getLastName();
	}
	
	
}
