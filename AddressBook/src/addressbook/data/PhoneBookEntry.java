package addressbook.data;

import java.io.Serializable;

public class PhoneBookEntry implements Serializable, Comparable<PhoneBookEntry>{
	
	private static final long serialVersionUID = -8058338785123813588L;
	private String firstName, lastName;
	private AddressType type;
	private Address address;
	private PhoneNumber number;

	public PhoneBookEntry(String firstName, String lastName, AddressType type,
			Address address, PhoneNumber number) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.address = address;
		this.number = number;
	}

	public PhoneNumber getNumber() {
		return number;
	}

	public void setNumber(PhoneNumber number) {
		this.number = number;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	@Override
	public String toString() {
		return "PhoneBookEntry [firstName=" + firstName + ", lastName="
				+ lastName + ", type=" + type + ", address=" + address
				+ ", number=" + number + "]";
	}

	@Override
	public int compareTo(PhoneBookEntry other) {
		return this.lastName.compareTo(other.getLastName());
	}
}
