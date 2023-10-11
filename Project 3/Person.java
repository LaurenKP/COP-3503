/**
 * Sets rubric for employee and customer class
 */
public class Person {
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	
	/**
	 * Assigns parameters with information
	 * @param firstName Persons first name
	 * @param lastName Persons last name
	 * @param address Persons address
	 * @param phoneNumber Persons phone number
	 * @param email Persons email address
	 */
	
	public Person(String firstName, String lastName, String address, String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	/**
	 * Gets first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets first name
	 * @param firstName First name of person
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets last name
	 * @param lastName Last name of person
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets address
	 * @param address Address of person
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Gets phone number
	 * @return Phone number of person
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets phone number
	 * @param phoneNumber Phone number of person
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets email
	 * @return email of person
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets email
	 * @param email Email of person
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
