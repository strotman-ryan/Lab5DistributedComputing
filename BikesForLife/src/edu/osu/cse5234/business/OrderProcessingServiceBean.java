package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	InventoryService inventoryService = ServiceLocator.getInventoryService();
    	inventoryService.validateQuantity(lineItemsToItems(order.getLineItems())); //Seems unnecessary
    	inventoryService.updateInventory(lineItemsToItems(order.getLineItems()));
    	return "123456789";
    }
    
    public boolean validateItemAvailability(Order order) {
    	
    	InventoryService inventoryService =  ServiceLocator.getInventoryService();
		return inventoryService.validateQuantity(lineItemsToItems(order.getLineItems()));
    }
    
    private List<Item> lineItemsToItems(List<LineItem> lineItems) {
    	List<Item> items = new ArrayList<Item>();
    	for (int i = 0; i < lineItems.size(); i++) {
    		Item tempItem = new Item();
    		tempItem.setName(lineItems.get(i).getName());
    		tempItem.setPrice(Double.toString(lineItems.get(i).getPrice()));
    		tempItem.setQuantity(Integer.toString(lineItems.get(i).getQuantity()));
    		tempItem.setItemNumber(lineItems.get(i).getItemNumber());
    	}
    	return items;
    }

}
