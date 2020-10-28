package edu.osu.cse5234.model;


import java.util.ArrayList;
import java.util.List;
public class Order {
	
	//Private Properties
	private List<LineItem> lineItems = new ArrayList<LineItem>();
	private int id;
	private String customerName;
	private String emailAddress;
	private ShippingInfo shippingInfo;
	private PaymentInfo paymentInfo;
	
	
	
	//Public Constructor
	public Order() {
		
	}
	
	//Items getter and setter
	public List<LineItem> getLineItems() {
		return this.lineItems;
	}
	
	public void setLineItems(List<LineItem> newLineItems) {
		this.lineItems = newLineItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	
}
