package model;

public class Customer {
	private long customerId;
	private String name;
	private String address;
	private String phoneNo;
	private String username;
	private String password;

	public Customer(String name, String address, String zipcode, String city, String phoneNo, String username,
			String password) {
		this.customerId = 0;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return customerId;
	}

	public void setId(long id) {
		this.customerId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
