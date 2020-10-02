package edu.osu.cse5234.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.*;
import java.util.ArrayList;
import java.util.List;
public class Order {
	//Private Properties
	private List<Item> items = new ArrayList<Item>();
	
	//Public Constructor
	public Order() {
		
	}
	
	//Items getter and setter
	public List<Item> getItems() {
		return this.items;
	}
	
	public void setItems(List<Item> newItems) {
		this.items = newItems;
	}
}
