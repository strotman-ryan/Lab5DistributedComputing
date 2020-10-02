package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.*;
@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) {
		Item item1 = new Item();
		item1.setName("Driver");
		item1.setPrice("100.00");
		item1.setQuantity("5");
		Item item2 = new Item();
		item2.setName("Golden Golf Balls");
		item2.setPrice("1,000,000");
		item2.setQuantity("1");
		Item item3 = new Item();
		item3.setName("4 Iron");
		item3.setPrice("56.01");
		item3.setQuantity("2");
		Item item4 = new Item();
		item4.setName("Professional lessons");
		item4.setPrice("1");
		item4.setQuantity("1,000");
		Item item5 = new Item();
		item5.setName("Gold Bag");
		item5.setPrice("43.52");
		item5.setQuantity("10");
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		Order order = new Order();
		order.setItems(items);
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String paymentEntry(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());
		return "PaymentEntryForm.jsp";
	}
	
	@RequestMapping(path="/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) {
		request.getSession().setAttribute("payment", payment);
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path="/shippingEntry", method = RequestMethod.GET)
	public String shippingEntry(HttpServletRequest request, HttpServletResponse response) {
		// ... instantiate and set shipping object to display
		request.getSession().setAttribute("shippingInfo", new ShippingInfo());
		return "ShippingEntryForm.jsp";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request, HttpServletResponse response) {
		// ... instantiate and order objects object to display
		return "ViewOrder.jsp";
	}
	
	//TODO: IDK how this function is supposed to work
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) {
		return "redirect:/purchase/viewConfirmation";
	}

	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) {
		return "Confirmation.jsp";
	}
	
	
}
