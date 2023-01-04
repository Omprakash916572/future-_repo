package com.test.dto;

public class Book {

	// For test commit
	private Integer id;
	private String name;
	private Integer pagees;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPagees() {
		return pagees;
	}

	public void setPagees(Integer pagees) {
		this.pagees = pagees;
	}

	public Book(Integer id, String name, Integer pagees) {
		this.id = id;
		this.name = name;
		this.pagees = pagees;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", pagees=" + pagees + "]";
	}

}
