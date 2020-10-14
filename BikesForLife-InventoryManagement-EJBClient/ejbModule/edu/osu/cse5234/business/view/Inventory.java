package edu.osu.cse5234.business.view;

import java.util.ArrayList;
import java.util.List;


public class Inventory implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1049157505250704405L;
	List<Item> listOfItems;

	
	public Inventory() {
		//Do nothing
	}
	public List<Item> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<Item> listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	
}
