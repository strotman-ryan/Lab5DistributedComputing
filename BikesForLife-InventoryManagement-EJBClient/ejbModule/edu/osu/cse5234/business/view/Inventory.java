package edu.osu.cse5234.business.view;

import java.util.ArrayList;

public class Inventory implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1049157505250704405L;
	ArrayList<Item> listOfItems;

	
	public Inventory() {
		//Do nothing
	}
	public ArrayList<Item> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(ArrayList<Item> listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	
}
