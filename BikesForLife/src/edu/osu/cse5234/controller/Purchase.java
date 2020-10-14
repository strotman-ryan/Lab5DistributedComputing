package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.osu.cse5234.util.*;
import edu.osu.cse5234.business.*;
import edu.osu.cse5234.business.view.*;
import edu.osu.cse5234.model.*;
@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) {
		Order order = new Order();	
		InventoryService inventoryService =  ServiceLocator.getInventoryService();
		Inventory inventory =  inventoryService.getAvailableInventory();
		order.setItems(inventory.getListOfItems());
		request.setAttribute("order", order);
		return "OrderEntryForm";
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		OrderProcessingServiceBean orderBean = ServiceLocator.getOrderProcessingService();
		if (orderBean.validateItemAvailability(order)) {
			request.getSession().setAttribute("order", order);
			return "redirect:/purchase/paymentEntry";
		}
		//TODO send error message
		return "redirect:/purchase/";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String paymentEntry(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path="/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) {
		request.getSession().setAttribute("payment", payment);
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path="/shippingEntry", method = RequestMethod.GET)
	public String shippingEntry(HttpServletRequest request, HttpServletResponse response) {
		// ... instantiate and set shipping object to display
		request.setAttribute("shippingInfo", new ShippingInfo());
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request, HttpServletResponse response) {
		// ... instantiate and order objects object to display
		return "ViewOrder";
	}
	
	//TODO: IDK how this function is supposed to work
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) {
		OrderProcessingServiceBean orderBean = ServiceLocator.getOrderProcessingService();
		Order order = (Order) request.getSession().getAttribute("order");
		String confirmationNumber = orderBean.processOrder(order);
		request.getSession().setAttribute("confNum", confirmationNumber);
		return "redirect:/purchase/viewConfirmation";
	}

	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) {
		return "Confirmation";
	}
	
	
}
