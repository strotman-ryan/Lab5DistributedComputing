package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    @PersistenceContext(unitName = "BikesForLife")
	private EntityManager entityManager;
    
    public String processOrder(Order order) {
    	if (validateItemAvailability(order)) {
    		entityManager.persist(order);
    		entityManager.flush();
    	}
    	return "123456789";
    }
    
    public boolean validateItemAvailability(Order order) {
		for (int i = 0; i < order.getLineItems().size(); i++) {
			LineItem currLineItem = order.getLineItems().get(i);
			Item itemMatch = findItemMatch(currLineItem);
			if (Integer.parseInt(itemMatch.getQuantity()) < currLineItem.getQuantity()) {
				return false;
			}
		}
		return true;
    }
    
    private Item findItemMatch(LineItem lineItem) {
    	InventoryService inventoryService = ServiceLocator.getInventoryService();
    	List<Item> items = inventoryService.getAvailableInventory().getListOfItems();
    	Item returnItem = new Item();
    	returnItem.setQuantity("0");
    	System.out.println("Line Item: " + lineItem.getItemNumber());
    	for (int i = 0; i < items.size(); i++) {
    		System.out.println("Item: " + items.get(i).getItemNumber());
    		if (items.get(i).getItemNumber() == lineItem.getItemNumber()) {
    			returnItem = items.get(i);
    		}
    	}
    	return returnItem;
    }

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
    
}
