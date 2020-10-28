package edu.osu.cse5234.business.view;

import javax.persistence.*;

@Entity
@Table(name="ITEM")
public class Item implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6205737053442725966L;
	
	//Private Properties
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="UNIT_PRICE")
	private String price;
	
	@Column(name="AVAILABLE_QUANTITY")
	private String quantity;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ITEM_NUMBER")
	private int itemNumber;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
