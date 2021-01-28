package com.demo.HibernateDemo.POJO;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentAddress {

	@Column(name = "City")
	private String city;
	
	@Column(name = "Country")
	private String country;

	public StudentAddress() {
		// TODO Auto-generated constructor stub
	}

	public StudentAddress(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
