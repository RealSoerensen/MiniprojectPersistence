package model;

public class Employee {
	String name;
	String username;
	String password;
	String title;
	public Employee(String name, String username, String password, String title) {
		this.name=name;
		this.username= username;
		this.password = password;
		this.title = title;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		username = username;
	}
	public String getpassword() {
		return password;
	}
	public void setPassword(String password) {
		password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		title = title;
	}
	
}
