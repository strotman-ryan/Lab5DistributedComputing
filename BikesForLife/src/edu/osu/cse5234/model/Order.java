package edu.osu.cse5234.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.*;
import java.util.ArrayList;
public class Order {
	//Private Properties
	ArrayList<Item> items = new ArrayList<Item>();
	
	//Public Constructor
	public Order() {
		
	}
	
	//Items getter and setter
	public ArrayList<Item> getItems() {
		return this.items;
	}
	public void setItems(ArrayList<Item> newItems) {
		this.items = newItems;
	}
}
