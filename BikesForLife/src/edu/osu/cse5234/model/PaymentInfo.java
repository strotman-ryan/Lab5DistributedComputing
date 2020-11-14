package edu.osu.cse5234.model;

import javax.persistence.*;

@Entity
@Table(name="PAYMENT_INFO")
public class PaymentInfo {
	//Private Properties
	
	@Column(name="CARD_NUM")
	private String creditCardNumber;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="EXP_DATE")
	private String expirationDate;
	
	@Column(name="CVV")
	private String cvvCode;
	
	@Column(name="HOLDER_NAME")
	private String cardholderName;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//Public Constructor
	public PaymentInfo() {
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	//Credit Card Number Getter and Setter
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	//Expiration Date Getter and Setter
	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	//CVV Code Getter and Setter
	public String getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}

	//Cardholder Name Getter and Setter
	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
