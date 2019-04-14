import java.util.ArrayList;

public class Warehouse {
	private ArrayList<Item> warehouse = new ArrayList<Item>();
	
	public Warehouse(){
	}
	
	public void addItem(Item newItem) {
		warehouse.add(newItem);
	}
	
	public void removeItem(Item item) {
		warehouse.remove(item);
	}
	
	public ArrayList<Item> warehouse() {
		/**
		 * Returns the list of items in warehouse
		 * @return: List of items in warehouse
		 */
		return warehouse;
	}
	
	public void moveItem(Item item, LairLocation location) {
		if (warehouse.contains(item)){
			location.addItem(item);
			removeItem(item);
		}
		else {
			throw new Error("Item is not in warehouse");
		}

	}
}
