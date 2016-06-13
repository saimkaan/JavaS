package addressbook.data;

import java.io.Serializable;

public class Address implements Serializable {
	
	private static final long serialVersionUID = -1669119194118254484L;
	private String street;
	private int streetNumber;
	private int postalCode;
	private String city;

	
	public Address(String street, int streetNumber, int postalCode, String city) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", streetNumber=" + streetNumber
				+ ", postalCode=" + postalCode + ", city=" + city + "]";
	}

	
}
