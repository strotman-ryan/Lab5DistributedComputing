package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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
	
	private static String SHIPPING_URI="http://localhost:9080/FedEx/services/shipping";
	
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
    		sendOrderToShipping(order);
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
    	for (int i = 0; i < items.size(); i++) {
    		if (items.get(i).getItemNumber() == lineItem.getItemNumber()) {
    			returnItem = items.get(i);
    		}
    	}
    	return returnItem;
    }
    private void sendOrderToShipping(Order order) {
    	Client client = ClientBuilder.newClient();
    	WebTarget baseTarget = client.target(SHIPPING_URI + "/initiate");
    	
    	JsonObject requestJson = Json.createObjectBuilder()
    					.add("Organization", "Bikes For Life Inc.")
    					.add("OrderRefId", 101)
    					.add("ItemsCount", orderQuantityFinder(order))
    					.add("Zip", order.getShippingInfo().getZip())
    					.build();
    	JsonObject responseJson = baseTarget.request(MediaType.APPLICATION_JSON)
    					.post(Entity.json(requestJson), JsonObject.class);
    	
    	System.out.println("FedEx accepted request? " + responseJson.getBoolean("Accepted"));
    	System.out.println("Shipping Reference Number: " + responseJson.getInt("ShippingReferenceNumber"));
    	
    	client.close();
    }
    private int orderQuantityFinder(Order order) {
    	int returnQuantityFinder = 0;
    	for (int i = 0; i < order.getLineItems().size(); i++ ) {
    		returnQuantityFinder += order.getLineItems().get(i).getQuantity();
    	}
    	return returnQuantityFinder;
    }

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
    
}
