package edu.osu.cse5234.model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="CUSTOMER_ORDER")
public class Order {
	
	//Private Properties
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
	private List<LineItem> lineItems;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SHIPPING_INFO_ID_FK")
	private ShippingInfo shippingInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PAYMENT_INFO_ID_FK")
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
