package edu.osu.cse5234.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.*;
import java.util.ArrayList;
import javax.persistence.*;

import javax.persistence.*;

@Entity
@Table(name="SHIPPING_INFO")
public class ShippingInfo {
	
	
	//Private Properties
	//Does not have respective column in table
	@Transient
	private String name;
	
	@Column(name="ADDRESS1")
	private String addressLine1;
	
	@Column(name="ADDRESS2")
	private String addressLine2;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="POSTAL_CODE")
	private String zip;
	
	@Column(name="EMAIL")
	private String email;
	
	//TODO: Add COUNTRY and EMAIL Inputs that are in database
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//Public Constructor
	public ShippingInfo() {
		
	}

	//Name Getter and Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Address Line 1 Getter and Setter
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	//Address Line 2 Getter and Setter
	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	//City Getter and Setter
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	//State Getter and Setter
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	//Zip Getter and Setter
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
