import java.util.ArrayList;


public class InventoryManagement {
	static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	public static void addItem(String name, int amount, float price, int shelf)
	{	
		Item item = new Item();
		item.setAmount(amount);
		item.setName(name);
		item.setPrice(price);
		item.setShelf(shelf);
		inventory.add(item);	
	}


	public static void removeItem(String toDelete) {
		for(int i = 0; i < inventory.size(); i++)
		{
			if(inventory.get(i).getName().equals(toDelete))
			{
				inventory.remove(i);
				System.out.println("Info for " + toDelete + " has been deleted.");
			}
		}
	}
	



	public static void searchInv(String toSearch) {
		boolean found = false;
		int counter = 0;
		while((found == false) && (counter < inventory.size()))
		{
			if(inventory.get(counter).getName().equals(toSearch))
			{
				found = true;
			}
			else
			{
				counter++;
			}
		}
		
		if(found == true)
		{
			System.out.print("\tItem information for " + toSearch +
					":\n\t\tAmount : " + inventory.get(counter).getAmount() 
					+ "\n\t\tPrice : " + inventory.get(counter).getPrice() 
					+ "\n\t\tLocation (shelf number) : " + inventory.get(counter).getShelf() + "\n");
		}
		else
		{
			System.out.println("\tNo such item in the inventory.\n");
		}
		
	}


	public static void updateItem(String toUpdate, int counter) {
		
		System.out.print("\tUpdated item information for " + toUpdate +
				":\n\t\tAmount : " + inventory.get(counter).getAmount() 
				+ "\n\t\tPrice : " + inventory.get(counter).getPrice() 
				+ "\n\t\tLocation (shelf number) : " + inventory.get(counter).getShelf() + "\n");		
	}

	public static void displayInventory() {
		System.out.print("The inventory has information about the following ");
		if(inventory.size() > 1)
		{
			System.out.println(inventory.size() + " items: ");
		}
		else
		{
			System.out.print("item: ");
		}
		
		for(int counter = 0; counter < inventory.size(); counter++)
		{
			System.out.println("\tItem information for " + inventory.get(counter).getName());
			
			System.out.println("\t\tAmount : " + inventory.get(counter).getAmount() 
			+ "\n\t\tPrice : " + inventory.get(counter).getPrice() 
			+ "\n\t\tLocation (shelf number) : " + inventory.get(counter).getShelf());
		}
		
	}

	public static void displayByShelf() {
		
		System.out.print("The inventory has information about the following ");
		
		if(inventory.size() > 1)
		{
			System.out.println(inventory.size() + " items: ");
		}
		else
		{
			System.out.print("item: ");
		}
		
		int maxShelf = 0;
		for(int i = 0; i < inventory.size(); i++)
		{
			if(inventory.get(i).getShelf() > maxShelf)
			{
				maxShelf = inventory.get(i).getShelf();
			}
		}
		
		for(int i = 1; i <= maxShelf; i++)
		{
			float shelfPriceTotal = 0;
			int itemsOnShelf = 0;
			for(int counter = inventory.size()-1; counter >= 0; counter--)
			{
				if(inventory.get(counter).getShelf() == i)
				{
					System.out.print("\tItem information for " + inventory.get(counter).getName() +
							":\n\t\tAmount : " + inventory.get(counter).getAmount() 
							+ "\n\t\tPrice : " + inventory.get(counter).getPrice() 
							+ "\n\t\tLocation (shelf number) : " + inventory.get(counter).getShelf() + "\n");
					
					itemsOnShelf += inventory.get(counter).getAmount();
					shelfPriceTotal += (inventory.get(counter).getAmount() * inventory.get(counter).getPrice());
				}
				if(counter == 0)
				{
					System.out.println("The inventory has a total of " + itemsOnShelf + " items "
							+ "with a cumulative price of $" + shelfPriceTotal + " on shelf " + i);
				}
			}
		}
	}
		
		

	
	public static void minmaxPrices()
	{
		float minPrice = inventory.get(0).getPrice();
		float maxPrice = inventory.get(0).getPrice();
		
		int minIndex = 0;
		int maxIndex = 0;
		
		for(int i = 0; i < inventory.size(); i++)
		{
			if(inventory.get(i).getPrice() < minPrice)
			{
				minPrice = inventory.get(i).getPrice();
				minIndex = i;
			}
			else if (inventory.get(i).getPrice() > maxPrice)
			{
				maxPrice = inventory.get(i).getPrice();
				maxIndex = i;
			}
		}
		
		System.out.println("\tThe most expensive item in the inventory is " + inventory.get(maxIndex).getName());
		
		System.out.println("\t\tAmount : " + inventory.get(maxIndex).getAmount() 
		+ "\n\t\tPrice : " + inventory.get(maxIndex).getPrice() 
		+ "\n\t\tLocation (shelf number) : " + inventory.get(maxIndex).getShelf());
		
		
		System.out.println("\tThe least expensive item in the inventory is " + inventory.get(minIndex).getName());
		
		System.out.println("\t\tAmount : " + inventory.get(minIndex).getAmount() 
		+ "\n\t\tPrice : " + inventory.get(minIndex).getPrice() 
		+ "\n\t\tLocation (shelf number) : " + inventory.get(minIndex).getShelf());
		
	}
	
}
	
	
