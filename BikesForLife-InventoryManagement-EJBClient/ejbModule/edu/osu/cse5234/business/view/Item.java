package edu.osu.cse5234.business.view;

public class Item implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6205737053442725966L;
	
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
