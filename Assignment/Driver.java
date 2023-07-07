import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	
	static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{	
		MenuHandling.printMenu();
		boolean switchOn = true;
		boolean firstResponse = true;
		int userIn = 0;
		
		while(switchOn == true)
		{
			if(firstResponse == true)
			{
				System.out.print("Make your menu selection now: ");
				firstResponse = false;
			}
			else
			{
				System.out.print("You know the options: ");
			}
			userIn = Integer.parseInt(stdin.readLine().trim());
			System.out.println(userIn);
			
			while(userIn > 1 && InventoryManagement.getInventory().size() == 0)
			{
				System.out.println("\tError: no items in the inventory.\nYou know the options: ");
				userIn = Integer.parseInt(stdin.readLine().trim());
			}
			
			switch(userIn)
			{
			case 0:
				switchOn = false;
				System.out.println("Goodbye!");
				break;
			case 1:		
				String name = "";
				float price = 0;
				int shelf = 0;
				int amount = 0;
				
				System.out.print("You are now adding a new item to the inventory. \n\tEnter name of the item: ");
				name = stdin.readLine().trim();
				System.out.println(name);				
				for(int i = 0; i < InventoryManagement.getInventory().size(); i++)
				{
					boolean nameTaken = false;
					if(InventoryManagement.getInventory().get(i).getName().equals(name))
					{
						nameTaken = true;
						while(nameTaken == true)
						{
							System.out.print("This item already exists in the inventory! Please specify another item: ");
							name = stdin.readLine().trim();
							if(InventoryManagement.getInventory().get(i).getName().trim().equals(name.trim()))
							{
								System.out.println("This item already exists in the inventory! Please specify another item: ");
								name = stdin.readLine().trim();
								System.out.println(name);				

							}
							else
							{
								nameTaken = false;
							}
						}
					}
				}
				System.out.print("\tEnter number of items of this type: ");
				amount = Integer.parseInt(stdin.readLine().trim());
				System.out.println(amount);
				
				System.out.print("\tEnter the price of items of this type: ");
				price = Float.parseFloat(stdin.readLine().trim());
				System.out.println(price);
				
				System.out.print("\tEnter the location of this item (shelf number): ");
				shelf = Integer.parseInt(stdin.readLine().trim());
				System.out.println(shelf);
				
				InventoryManagement.addItem(name, amount, price, shelf);
				System.out.println("\n");
				break;
			case 2:
				System.out.println("Enter the name of the item you want deleted: ");
				String toDelete = stdin.readLine().trim();
				System.out.println(toDelete);
				InventoryManagement.removeItem(toDelete);
				break;
				
			case 3:
				System.out.println("Enter the name of the item in the inventory to search for: ");
				String toSearch = stdin.readLine().trim();
				System.out.println(toSearch);
				InventoryManagement.searchInv(toSearch);
				break;
			
			case 4:
				System.out.print("Enter the name of the item in the inventory to update the amount: ");
				String toUpdate = stdin.readLine().trim();
				System.out.print(toUpdate);
				
				boolean found = false;
				int counter = 0;
				while((found == false) && (counter < InventoryManagement.getInventory().size()))
				{
					if(InventoryManagement.getInventory().get(counter).getName().equals(toUpdate))
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
					System.out.print("\nEnter the new amount: ");
					int newNum = Integer.parseInt(stdin.readLine());
					System.out.println(newNum);
					
					if(newNum > 0)
					{
					InventoryManagement.getInventory().get(counter).setAmount(newNum);
					InventoryManagement.updateItem(toUpdate, counter);
					}
					else
					{
						InventoryManagement.removeItem(toUpdate);
					}
				}
				else
				{
					System.out.println("\tNo such item in the inventory.\n");
				}
				break;
				
			case 5:
				InventoryManagement.displayInventory();
				break;
				
			case 6:
				InventoryManagement.displayByShelf();
				break;
				
			case 7:
				InventoryManagement.minmaxPrices();
				break;
				
			default:
					
				break;
			
			
			}
		}
	}
}
