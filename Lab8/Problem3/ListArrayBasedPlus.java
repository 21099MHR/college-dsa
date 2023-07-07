/*

 * Purpose: Data Structure and Algorithms Lab 2 Problem 1

 * Status: Complete and thoroughly tested

 * Last update: 02/4/20

 * Submitted:  02/4/20

 * Comment: test suite and sample run attached

 * @author: Matthew Ryan

 * @version: 2020.02.4

 */

public class ListArrayBasedPlus extends ListArrayBased {
	
	ListArrayBasedPlus()
	{
		super();
	}

	public void add(String item) throws  ListIndexOutOfBoundsException
	{
		if(numItems == items.length)
		{
			resizeArray();
		}
		super.add(item.toString());
	}

	private static void resizeArray() {
		Object newItems[] = new Object[items.length + 1];

		for(int i = 0; i < items.length; i++)
		{
			newItems[i] = items[i];
		}
		
		items = newItems;
		}
	
	public void toString(Object []items)
	{
		for(int i = 0; i < items.length; i++)
		{
			System.out.print(items[i]);
		}
	}
	
	public void reverseArray()
	{
		Object reverseArray[] = new Object[items.length];
		int tracker = items.length;
		for(int i = 0; i < items.length; i++)
		{
			reverseArray[i] = items[tracker - 1];
			tracker -= 1;
		}
		
		items = reverseArray;
	}
}