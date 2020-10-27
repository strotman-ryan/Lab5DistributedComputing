package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.InventoryService;
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
    	inventoryService.validateQuantity(order.getItems()); //Seems unnecessary
    	inventoryService.updateInventory(order.getItems());
    	return "123456789";
    }
    
    public boolean validateItemAvailability(Order order) {
    	
    	InventoryService inventoryService =  ServiceLocator.getInventoryService();
		return inventoryService.validateQuantity(order.getItems());
    }

}
