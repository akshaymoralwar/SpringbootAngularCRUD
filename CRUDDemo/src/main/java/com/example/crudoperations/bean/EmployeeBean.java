/**
 * @author Akshay Moralwar
 * */
package com.example.crudoperations.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * EmployeeBean is a POJO class mapped with the DB table.
 * The table contains attributes and setters and getters. 
 */
@Entity
@Table(name = "employee")
public class EmployeeBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private String address;
	@Column
	private Date dob;
	@Column
	private String mobile;
	@Column
	private String organization;
	@Column
	private String email;
	@Column
	private String city;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "EmployeeBean [id=" + id  + ", first_name=" + first_name + ", last_name=" + last_name + ", address="
				+ address + ", dob=" + dob + ", mobile=" + mobile + ", organization=" + organization + ", email="
				+ email + ", city=" + city + "]";
	}

}
