/*

 * Purpose: Data Structure and Algorithms Lab 8 Problem 1

 * Status: Complete and thoroughly tested

 * Last update: 04/6/20

 * Submitted:  04/7/20

 * Comment: test suite and sample run attached

 * @author: Matthew Ryan

 * @version: 2020.04.6

 */

import io.github.pixee.security.BoundedLineReader;
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
			int selection = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
			System.out.println(selection);
			
			switch(selection)
			{
			case 1:
				System.out.print("\nYou are now inserting an item into the list.\n\tEnter item: ");
				Object item = BoundedLineReader.readLine(stdin, 5_000_000).trim();
				System.out.println(item);
				
				System.out.print("\tEnter position to insert item in: ");
				int index = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
				System.out.println(index);
				
				if(index >= items.size()+1)
				{
					System.out.println("\nPosition specified is out of range!");
				}
				else
				{
				items.add(index, item);
				System.out.println("\nItem " + item + " inserted at position " + index + " in the list.");
				}
				break;
			case 2:
				System.out.print("\tEnter position to remove item from: ");
				int toRemove = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
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
				int toRetrieve = Integer.parseInt(BoundedLineReader.readLine(stdin, 5_000_000).trim());
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
				Object toSearch = BoundedLineReader.readLine(stdin, 5_000_000).trim();
				int search = search(toSearch, items);
				
				if(search < (items.size()-1) + 10)
				{
					System.out.println("Item " + toSearch + " found at Index " + search + ".");
				}
				else
				{
					System.out.println("Item " + toSearch + " not found in list."
							+ "\nWould be inserted at Index " + (search-10) + ".");
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

	private static int search(Object toSearch, ListArrayBasedPlus items) {
	
		boolean found = false;
		int counter = 0;
		int itemsSize = items.size()-1;
		
		while(found == false && (counter <= itemsSize))
		{
			if(items.get(counter).equals(toSearch))
			{
				found = true;
			}
			else
			{
				counter++;
			}
		}
		
		if(found == false)
		{
			counter += 10;
		}
		
		return counter;
	}
}
