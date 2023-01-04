package com.test.dto;

import java.util.List;

public class Customer {

	private Integer id;
	private String email;
	private List<String> phoneNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}

	public Customer(Integer id, String email, List<String> phoneNumber) {
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Customer() {
	}

}
