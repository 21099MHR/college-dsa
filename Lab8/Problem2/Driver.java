/*

 * Purpose: Data Structure and Algorithms Lab 2 Problem 1

 * Status: Complete and thoroughly tested

 * Last update: 02/4/20

 * Submitted:  02/4/20

 * Comment: test suite and sample run attached

 * @author: Matthew Ryan

 * @version: 2020.02.4

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	
	static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

	public static <T> void main(String[] args) throws NumberFormatException, IOException {
		
		ListArrayBasedPlus items = new 	ListArrayBasedPlus();		
		boolean switchOn = true;
		
		System.out.println("\nSelect from the following menu: \n\t1.Insert item into list." + 
				"\n\t2. Remove item from list." + 
				"\n\t3. Get item from list." + 
				"\n\t4. Search for a specified item in the list." + 
				"\n\t5. Clear list." + 
				"\n\t6. Print size and content of list." + 
				"\n\t7. Exit program.");
			
		while(switchOn == true)
		{
			System.out.print("\nMake your selection now: ");
			int selection = Integer.parseInt(stdin.readLine().trim());
			System.out.println(selection);
			
			switch(selection)
			{
			case 1:
				System.out.print("\nYou are now inserting an item into the list.\n\tEnter item: ");
				Object item = stdin.readLine().trim();
				System.out.println(item);
				
				int toAdd = search(item, items, true);
				
				if(toAdd < 0)
				{
					System.out.println("Object already exists in list!");
				}
				else
				{
					items.add(toAdd, item);
				}
				
				break;
			case 2:
				System.out.print("\tEnter position to remove item from: ");
				int toRemove = Integer.parseInt(stdin.readLine().trim());
				System.out.println(toRemove);
				
				if((toRemove >= items.size()) || (toRemove < 0))
				{
					System.out.println("\nPosition specified is out of range!");
				}
				else
				{
					System.out.println("\nItem " + items.get(toRemove) + " removed from position " + toRemove + " in the list.");
				items.remove(toRemove);
				}
				break;
			case 3:
				System.out.print("\t\nEnter position to retrieve item from: ");
				int toRetrieve = Integer.parseInt(stdin.readLine().trim());
				System.out.println(toRetrieve);
				
				if((toRetrieve >= items.size()) || (toRetrieve < 0))
				{
					System.out.println("\nPosition specified is out of range!");
				}
				else
				{
					System.out.println("\nItem " + items.get(toRetrieve) + " retrieved from position " + toRetrieve + " in the list."); 
				}
				break;
			case 4:
				if(items.size() == 0)
				{
					System.out.println("List is empty!");
				}
				else
				{
				System.out.print("Specify item to search for: ");
				Object toSearch = stdin.readLine().trim();
				int search = search(toSearch, items, false);
				
				if(search < items.size())
				{
					System.out.println("Item " + toSearch + " found at Index " + search + ".");
				}
				else
				{
					System.out.println("Item " + toSearch + " not found in list."
							+ "\nWould be inserted at Index " + search(toSearch, items, true) + ".");
				}
				}
				break;
			case 5:
				items.removeAll();
				break;
			case 6:
				
				if(items.size() == 0)
				{
					System.out.println("List is empty.");
				}
				else
				{
				System.out.print("List of size " + items.size() + " has the following items: ");
				
				for(int i = 0; i < items.size(); i++)
				{
					System.out.print(items.get(i) + " ");
				}
				}
				break;
			case 7:
				switchOn = false;
				System.out.print("Exiting program...Good Bye");
				break;
			}
		}
		
	}

	/**
	 * This MSS is eagerly checking for a Stop condition - either
	 * the counter equaling out the Size or the passed in object being less
	 * than the current counter's value in terms of compareTo.
	 * 
	 * @param toSearch
	 * @param items
	 * @return
	 */
	
	private static int search(Object toSearch, ListArrayBasedPlus items, Boolean adding) {
	
		boolean found = false;
		int counter = 0;
		int itemsSize = items.size();
		
		Object foundItem = null;
		String compare = toSearch.toString();
		
		while((found == false) && (counter <= itemsSize))
		{
			if(counter == itemsSize)
			{
				found = true;
			}
			else if((compare.compareTo(items.get(counter).toString()) <= 0) && (adding == true))
			{
				foundItem = items.get(counter);
				found = true;
			}
			else if((adding == false) && compare.equals(items.get(counter).toString()))
			{
				foundItem = items.get(counter);
				found = true;
			}
			else
			{
			counter++;
			}
		}
		
		if((compare.equals(foundItem)) && (adding == true))
		{
			counter = -1;
		}
		
		return counter;
	}
}
