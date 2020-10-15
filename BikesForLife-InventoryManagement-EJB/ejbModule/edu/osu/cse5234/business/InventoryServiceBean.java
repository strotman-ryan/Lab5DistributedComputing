package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {

    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		Item item1 = new Item();
		item1.setName("Derailleur");
		item1.setPrice("100.00");
		item1.setQuantity("5");
		Item item2 = new Item();
		item2.setName("Carbon Fiber Pedals");
		item2.setPrice("1,000,000");
		item2.setQuantity("1");
		Item item3 = new Item();
		item3.setName("Handlebar");
		item3.setPrice("56.01");
		item3.setQuantity("2");
		Item item4 = new Item();
		item4.setName("Professional lessons");
		item4.setPrice("1");
		item4.setQuantity("1,000");
		Item item5 = new Item();
		item5.setName("Gold Chain");
		item5.setPrice("43.52");
		item5.setQuantity("10");
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		Inventory newInventory = new Inventory();
		newInventory.setListOfItems(items);
		return newInventory;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		// TODO STUB, fix later
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		// TODO STUB, fix later
		return true;
	}

}
