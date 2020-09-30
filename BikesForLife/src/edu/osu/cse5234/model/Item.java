package edu.osu.cse5234.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.osu.cse5234.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class Item {
	//Private Properties
	private String name;
	private String price;
	private String quantity;
	//Public Constructor
	public Item() {
		
	}
	
	//Name getter and setter
	public String getName() {
		return this.name;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	
	//Price getter and setter
	public String getPrice() {
		return this.price;
	}
	public void setPrice(String newPrice) {
		this.price = newPrice;
	}
	
	//Quantity getter and setter
	public String getQuantity() {
		return this.quantity;
	}
	public void setQuantity(String newQuantity) {
		this.quantity = newQuantity;
	}
	
}
