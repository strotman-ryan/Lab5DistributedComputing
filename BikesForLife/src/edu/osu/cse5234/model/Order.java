package edu.osu.cse5234.model;


import edu.osu.cse5234.business.view.Item;
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
