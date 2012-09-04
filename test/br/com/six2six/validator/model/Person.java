package br.com.six2six.validator.model;

public class Person {
	
	private String name;
	private int age;
	private Address homeAddress;
	private Address workingAddress;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getWorkingAddress() {
		return workingAddress;
	}

	public void setWorkingAddress(Address workingAddress) {
		this.workingAddress = workingAddress;
	}

}
