package edu.osu.cse5234.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.*;
import java.util.ArrayList;

public class PaymentInfo {
	//Private Properties
	private String creditCardNumber;
	private String expirationDate;
	private String cvvCode;
	private String cardholderName;
	
	//Public Constructor
	public PaymentInfo() {
		
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
	
}
